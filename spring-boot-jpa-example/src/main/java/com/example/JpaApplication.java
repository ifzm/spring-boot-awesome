package com.example;

import com.example.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public JpaApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        userRepository.findByEmail("214123975@qq.com").forEach(user -> log.warn(user.toString()));
        log.warn(userRepository.findById("2").toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}
