package com.ifzm;

import com.ifzm.domain.User;
import com.ifzm.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MybatisApplication implements CommandLineRunner {

    private final UserMapper userMapper;

    public MybatisApplication(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userMapper.find(User.builder().username("iguoguo").email("devfzm@gmail.com").build())
                .forEach(user -> log.warn(user.toString()));

        userMapper.findByEmail("214123975@qq.com")
                .forEach(user -> log.warn(user.toString()));

        log.warn(userMapper.findOne("2").toString());
    }
}
