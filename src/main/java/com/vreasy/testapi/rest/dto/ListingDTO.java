package com.vreasy.testapi.rest.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "listing" , description = "description of the listing")
public class ListingDTO extends GenericDTO {

    @NotEmpty
    @ApiModelProperty(value = "title of the listing")
    private String title;
    
}
