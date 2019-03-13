package com.vreasy.testapi.repository;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.vreasy.testapi.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void testShouldFindUser() {
        User user = new User();
        user.setUsername("username@vreasy.com");
        user.setPassword("my password");
        user = entityManager.persistAndFlush(user);

        User actualUser = userRepository.findById(user.getId()).get();
        
        assertThat(actualUser, IsEqual.equalTo(user));
        
    }

}
