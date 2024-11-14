package com.inmemory.auth.infrastructure.repository.redis;

import com.inmemory.auth.domain.model.aggregate.Auth;
import com.inmemory.auth.domain.repository.AuthRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthCrudRepository extends AuthRepository, CrudRepository<Auth, String> {}
