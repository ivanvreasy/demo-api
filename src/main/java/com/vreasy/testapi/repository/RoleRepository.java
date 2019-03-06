package com.vreasy.testapi.repository;

import com.vreasy.testapi.model.Role;

public interface RoleRepository extends GenericRepository<Role> {

    Role findByName(String name);

}
