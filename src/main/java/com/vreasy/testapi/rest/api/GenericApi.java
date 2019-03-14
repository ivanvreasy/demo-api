package com.vreasy.testapi.rest.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.vreasy.testapi.model.GenericModel;
import com.vreasy.testapi.rest.dto.GenericDTO;
import com.vreasy.testapi.rest.dto.Mapper;
import com.vreasy.testapi.service.GenericService;

public abstract class GenericApi<T extends GenericDTO, K extends GenericModel> {

    protected static final String DEFAULT_PAGE = "0";
    protected static final String DEFAULT_SIZE = "5";

    private final Class<T> classDTO;
    private final Class<K> classModel;

    protected final Mapper<K, T> mapper;
    protected final GenericService<K> service;
    

    public GenericApi(Mapper<K, T> mapper, GenericService<K> service, Class<T> classDTO, Class<K> classModel) {
        this.mapper = mapper;
        this.service = service;
        this.classDTO = classDTO;
        this.classModel = classModel;
    }

    @GetMapping
    public HttpEntity<List<T>> findAll( 
            @RequestParam(name = "page", defaultValue = DEFAULT_PAGE, required = false) Integer page,
            @RequestParam(name = "size", defaultValue = DEFAULT_SIZE, required = false) Integer size,
            UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        
        Page<K> pageResult = service.findAll(page, size);
        List<K> models = pageResult.getContent();
        List<T> entities = mapper.convertToDto(models, classDTO);
        
        String linkHeader = UrlBuilder.addLinkHeaderOnPagedResourceRetrieval(uriBuilder, getResourceName(),
                pageResult.getNumber(), pageResult.getTotalPages(), pageResult.getNumberOfElements());
        response.addHeader(HttpHeaders.LINK, linkHeader);

        return ResponseEntity.ok().body(entities);
    }

    @GetMapping("/{id}")
    public HttpEntity<T> findById(@PathVariable Long id) {

        K model = service.findById(id);

        return model != null ? ResponseEntity.ok().body(mapper.convertToDto(model, classDTO))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid T entity) {
        service.create(mapper.convertFromDto(entity, classModel));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid T entity) {
        service.update(mapper.convertFromDto(entity, classModel));
    }

    @DeleteMapping("/{id}")
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    protected abstract String getResourceName();
       
}
