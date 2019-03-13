package com.vreasy.testapi.rest.api;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.vreasy.testapi.audit.AuditConfiguration;
import com.vreasy.testapi.model.Listing;
import com.vreasy.testapi.model.Privilege;
import com.vreasy.testapi.rest.dto.ListingDTO;
import com.vreasy.testapi.rest.dto.Mapper;
import com.vreasy.testapi.service.ListingService;

@RunWith(SpringRunner.class)
@WebMvcTest(ListingApi.class)
@ContextConfiguration(classes=AuditConfiguration.class)
public class ListingApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListingService listingService;
    
//    @Test
    public void testFindAllListingsNoAuth() throws Exception {
        this.mockMvc.perform(
                get("/" + ListingApi.RESOURCE_NAME).contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
    
    @WithMockUser(authorities = {Privilege.READ_PRIVILEGE})
//    @Test
    public void testFindAllListings() throws Exception {

        // given(listingService.findAll()).willReturn(allListings);

        // mockMvc.perform(get("/" + ListingApi.RESOURCE_NAME)
        // .contentType(MediaType.APPLICATION_JSON))
        // .andExpect(status().isOk())
        // .andExpect(jsonPath("$", hasSize(1)))
        // .andExpect(jsonPath("$[0].title", is(listing.getTitle())));
        

        this.mockMvc.perform(get("/" + ListingApi.RESOURCE_NAME + "?page=0&size=5").contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Listing tittle")));
    }
    
    @WithMockUser(authorities = {Privilege.READ_PRIVILEGE})
    @Test
    public void testFindListingById() throws Exception {
        
        Long id = Mockito.anyLong();
        final Listing listing = new Listing();
        listing.setId(id);
        listing.setTitle("Listing tittle");
        
        when(listingService.findById(id)).thenReturn(listing);
        

        this.mockMvc.perform(
                get("/" + ListingApi.RESOURCE_NAME + "/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Listing tittle")));
        
        
    }

}
