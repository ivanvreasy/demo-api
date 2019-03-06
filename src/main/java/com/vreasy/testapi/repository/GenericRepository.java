package com.vreasy.testapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vreasy.testapi.model.GenericModel;

public interface GenericRepository<T extends GenericModel> extends PagingAndSortingRepository<T, Long> {
    
    @Override
    public List<T> findAll();
}
