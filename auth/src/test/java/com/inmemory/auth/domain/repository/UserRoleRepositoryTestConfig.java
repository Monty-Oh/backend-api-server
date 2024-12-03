package com.inmemory.auth.domain.repository;

import com.inmemory.auth.infrastructure.repository.UserRoleRepositoryImpl;
import com.inmemory.auth.infrastructure.repository.jpa.UserRoleJpaRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class UserRoleRepositoryTestConfig {

    @Bean
    public UserRoleRepository userRoleRepository(UserRoleJpaRepository userRoleJpaRepository) {
        return new UserRoleRepositoryImpl(userRoleJpaRepository);
    }
}
