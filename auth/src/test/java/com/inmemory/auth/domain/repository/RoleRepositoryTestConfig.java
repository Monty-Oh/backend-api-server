package com.inmemory.auth.domain.repository;

import com.inmemory.auth.infrastructure.repository.RoleRepositoryImpl;
import com.inmemory.auth.infrastructure.repository.jpa.RoleJpaRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class RoleRepositoryTestConfig {

    @Bean
    public RoleRepository roleRepository(RoleJpaRepository roleJpaRepository) {
        return new RoleRepositoryImpl(roleJpaRepository);
    }
}
