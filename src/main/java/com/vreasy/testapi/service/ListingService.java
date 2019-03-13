package com.vreasy.testapi.service;

import org.springframework.stereotype.Service;

import com.vreasy.testapi.model.Listing;
import com.vreasy.testapi.repository.ListingRepository;

@Service
public class ListingService extends GenericService<Listing> {
    

    public ListingService(ListingRepository listingRepository) {
        super(listingRepository);
    }
}
