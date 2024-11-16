package com.inmemory.auth.domain.repository;

import com.inmemory.auth.infrastructure.repository.AuthRepositoryImpl;
import com.inmemory.auth.infrastructure.repository.redis.AuthRedisRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class AuthRepositoryTestConfig {

    @Bean
    public AuthRepository authRepository(AuthRedisRepository authRedisRepository) {
        return new AuthRepositoryImpl(authRedisRepository);
    }
}
