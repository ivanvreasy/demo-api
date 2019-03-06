package com.vreasy.testapi.rest.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.vreasy.testapi.model.GenericModel;

@Component
public class Mapper<T extends GenericModel, K extends GenericDTO> {
    
    private final ModelMapper modelMapper;
    
    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    public K convertToDto(T model, Class<K> dtoClass) {
        return modelMapper.map(model,  dtoClass);
    }
    
    public T convertFromDto(K dto, Class<T> modelClass) {
        return modelMapper.map(dto, modelClass);
    }

}
