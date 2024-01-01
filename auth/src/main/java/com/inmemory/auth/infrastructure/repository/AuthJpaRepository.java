package com.inmemory.auth.infrastructure.repository;

import com.inmemory.auth.domain.aggregate.Auth;
import com.inmemory.auth.domain.repository.AuthRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthJpaRepository extends AuthRepository, JpaRepository<Auth, String> {
}
