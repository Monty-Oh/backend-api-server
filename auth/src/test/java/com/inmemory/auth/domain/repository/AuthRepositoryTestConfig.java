package com.inmemory.auth.domain.repository;

import com.inmemory.auth.infrastructure.repository.AuthRepositoryImpl;
import com.inmemory.auth.infrastructure.repository.redis.AuthRedisRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import java.io.IOException;

@TestConfiguration
public class AuthRepositoryTestConfig {

    @Bean
    public AuthRepository authRepository(AuthRedisRepository authRedisRepository) {
        return new AuthRepositoryImpl(authRedisRepository);
    }
}
