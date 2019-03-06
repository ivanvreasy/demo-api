package com.vreasy.testapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Privilege extends GenericModel {

    
    private String name;
    
    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;
}
