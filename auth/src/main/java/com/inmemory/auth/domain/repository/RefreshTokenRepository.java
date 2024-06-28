package com.inmemory.auth.domain.repository;

import com.inmemory.auth.domain.model.aggregate.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByUserNo(String userNo);
}
