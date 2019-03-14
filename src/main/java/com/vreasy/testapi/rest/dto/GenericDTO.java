package com.vreasy.testapi.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public abstract class GenericDTO {

    @ApiModelProperty(value = "Unique ID", accessMode = AccessMode.READ_ONLY)
    private Long id;

}
