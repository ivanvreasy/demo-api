package com.vreasy.testapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vreasy.testapi.model.Role;
import com.vreasy.testapi.model.User;
import com.vreasy.testapi.repository.GenericRepository;
import com.vreasy.testapi.repository.RoleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService extends GenericService<User> {

    private final RoleRepository roleRepository;

    public UserService(GenericRepository<User> repository, RoleRepository roleRepository) {
        super(repository);
        this.roleRepository = roleRepository;
    }

    public void signup(User user) {

        Role roleUser = roleRepository.findByName(Role.ROLE_USER);
        user.setRoles(Arrays.asList(roleUser));
        log.info("Creating new user {} with role {}", user, roleUser);

        create(user);
    }

}
