package com.vreasy.testapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vreasy.testapi.model.Listing;

public interface ListingRepository extends GenericRepository<Listing> {
    
    public List<Listing> findByTitle(String title);
    
    public Page<Listing> findByTitle(String title, Pageable pageable);

}
