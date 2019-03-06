package com.vreasy.testapi.rest.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vreasy.testapi.model.Role;
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
    
    @Override
    @PreAuthorize("hasRole('" + Role.ROLE_ADMIN + "')")
    public HttpEntity<List<UserDTO>> findAll( 
            @RequestParam(name = "page", defaultValue = DEFAULT_PAGE, required = false) Integer page,
            @RequestParam(name = "size", defaultValue = DEFAULT_SIZE, required = false) Integer size,
            UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        return super.findAll(page, size, uriBuilder, response);
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
