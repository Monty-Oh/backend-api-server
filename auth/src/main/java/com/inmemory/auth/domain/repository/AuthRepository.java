package com.inmemory.auth.domain.repository;

import com.inmemory.auth.domain.model.aggregate.Auth;

import java.util.Optional;

public interface AuthRepository {
    Optional<Auth> findByUserNo(String authNo);

    Auth save(Auth auth);
}
