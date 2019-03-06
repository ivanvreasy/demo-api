package com.vreasy.testapi.rest.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vreasy.testapi.model.User;
import com.vreasy.testapi.rest.dto.Mapper;
import com.vreasy.testapi.rest.dto.UserDTO;
import com.vreasy.testapi.service.UserService;

@RestController
@RequestMapping("/" + UserApi.RESOURCE_NAME)
public class UserApi extends GenericApi<UserDTO, User> {
    
    protected static final String RESOURCE_NAME = "users";
    
    private final UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserApi(Mapper<User, UserDTO> mapper, UserService userService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(mapper, userService, UserDTO.class, User.class);
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @Valid UserDTO userDTO) {
        User user = mapper.convertFromDto(userDTO, User.class);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userService.signup(user);
    }

    @Override
    protected String getResourceName() {
        return RESOURCE_NAME;
    }
}
