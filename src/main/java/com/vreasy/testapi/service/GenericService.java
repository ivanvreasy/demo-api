package com.vreasy.testapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.vreasy.testapi.model.GenericModel;
import com.vreasy.testapi.repository.GenericRepository;

public abstract class GenericService<T extends GenericModel> {

    private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void create(T model) {
        repository.save(model);
    }

    public void update(T model) {
        repository.save(model);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Page<T> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<T> result = repository.findAll(pageable);
        return result;
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
