package com.example;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@Slf4j
@MapperScan("com.example.mapper")
@SpringBootApplication
public class AtomikosApplication implements CommandLineRunner {

    @Resource(name = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @Resource(name = "jdbcTemplateMysql")
    JdbcTemplate jdbcTemplateMysql;

    private final UserMapper userMapper;

    public AtomikosApplication(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(AtomikosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.query("select * from USER", BeanPropertyRowMapper.newInstance(User.class))
                .forEach(user -> log.warn(user.toString()));

        jdbcTemplateMysql.query("select * from USER", BeanPropertyRowMapper.newInstance(User.class))
                .forEach(user -> log.warn(user.toString()));

        log.error(userMapper.findOne("1").toString());
    }

}
