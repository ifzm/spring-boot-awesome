package com.ifzm;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatis {

    @Autowired
    UserMapper userMapper;

    @Test
    public void findByEmail() {
        String email = "214123975@qq.com";
        userMapper.findByEmail(email)
                .forEach(user -> assertThat(user.getEmail()).isEqualTo(email));
    }

    @Test
    public void findOne() {
        User user = userMapper.findOne("1");
        assertThat(user).isNotNull();
    }

    @Test
    public void find() {
        String username = "ifzm";
        String email = "214123975@qq.com";

        userMapper.find(User.builder().username(username).build())
                .forEach(user -> assertThat(user.getUsername()).isEqualTo(username));

        userMapper.find(User.builder().username(username).email(email).build())
                .forEach(user -> {
                    assertThat(user.getUsername()).isEqualTo(username);
                    assertThat(user.getEmail()).isEqualTo(email);
                });
    }
}
