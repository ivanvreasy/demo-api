package com.vreasy.testapi.repository;

import com.vreasy.testapi.model.User;

public interface UserRepository extends GenericRepository<User> {
    
    public User findByUsername(String username);

}
