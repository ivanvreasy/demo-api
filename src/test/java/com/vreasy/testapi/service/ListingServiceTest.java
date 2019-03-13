package com.vreasy.testapi.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vreasy.testapi.model.Listing;
import com.vreasy.testapi.repository.ListingRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListingServiceTest {
    
    @Autowired
    private ListingService listingService;
    
    @MockBean
    private ListingRepository listingRepository;
    
    @Before
    public void before() {
        Long id = Mockito.anyLong();
        
        Listing listing = new Listing();
        listing.setId(id);
        listing.setTitle("Random title");
        Mockito.when(listingRepository.findById(id)).thenReturn(Optional.of(listing));
    }
    
    @Test
    public void testFindById() {
        
        Listing listing = listingService.findById(1L);
        Assert.assertNotNull(listing);
    }

}
