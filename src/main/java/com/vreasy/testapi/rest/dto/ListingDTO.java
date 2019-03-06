package com.vreasy.testapi.rest.dto;

import javax.validation.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ListingDTO extends GenericDTO {

    @NotEmpty
    private String title;
    
}
