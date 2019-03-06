package com.vreasy.testapi.rest.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vreasy.testapi.model.Listing;
import com.vreasy.testapi.rest.dto.ListingDTO;
import com.vreasy.testapi.rest.dto.Mapper;
import com.vreasy.testapi.service.ListingService;

@RestController
@RequestMapping("/" + ListingApi.RESOURCE_NAME)
public class ListingApi extends GenericApi<ListingDTO, Listing> {
    
    protected static final String RESOURCE_NAME = "listings";
    
    public ListingApi(Mapper<Listing, ListingDTO> mapper, ListingService listingService) {
        super(mapper, listingService, ListingDTO.class, Listing.class);
    }
    
    @Override
    protected String getResourceName() {
        return RESOURCE_NAME;
    }    
}
