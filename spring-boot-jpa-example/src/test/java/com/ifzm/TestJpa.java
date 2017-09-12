package com.ifzm;

import com.ifzm.domain.User;
import com.ifzm.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByEmail() {
        String email = "214123975@qq.com";
        userRepository.findByEmail(email).forEach(e -> assertThat(e.getEmail()).isEqualTo(email));
    }

    @Test
    public void findOne() {
        User user = userRepository.findOne("1");
        assertThat(user).isNotNull();
    }
}