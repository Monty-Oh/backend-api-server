package com.inmemory.auth.infrastructure.repository.redis;

import com.inmemory.auth.domain.model.aggregate.Auth;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRedisRepository extends CrudRepository<Auth, String> {
}
