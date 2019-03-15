package com.vreasy.testapi.rest.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "listing" , description = "The listing is the representation of the property in a specific channel")
public class ListingDTO extends GenericDTO {

    @NotEmpty
    @ApiModelProperty(value = "title of the listing")
    private String title;

    
    @NotEmpty
    @Size(max = 255)
    @ApiModelProperty(value = "description of the listing")
    private String description;

    
}
