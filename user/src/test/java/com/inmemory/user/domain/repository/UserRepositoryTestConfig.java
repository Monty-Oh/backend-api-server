package com.inmemory.user.domain.repository;

import com.inmemory.user.infrastructure.repository.UserRepositoryImpl;
import com.inmemory.user.infrastructure.repository.jpa.UserJpaRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class UserRepositoryTestConfig {

    @Bean
    public UserRepository userRepository(UserJpaRepository userJpaRepository) {
        return new UserRepositoryImpl(userJpaRepository);
    }
}
