package com.vreasy.testapi.rest.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends GenericDTO {

    @NotNull
    private String username;

    @NotNull
    @Size(min=8, message="Password should have atleast 8 characters")
    private String password;
}
