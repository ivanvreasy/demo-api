package com.vreasy.testapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends GenericModel {
    
    public static final String  ROLE_ADMIN   = "ROLE_ADMIN";
    public static final String  ROLE_USER    =  "ROLE_USER";
    
    private String name;
    
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
    
    
    @ManyToMany
    @JoinTable(
        name = "roles_privileges", 
        joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilege_id", referencedColumnName = "id"))
    private List<Privilege> privileges;   
}
