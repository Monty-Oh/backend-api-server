package com.inmemory.user.domain.repository;

import com.inmemory.user.domain.model.aggregate.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUserNo(String userNo);

    Optional<User> findByLoginId(String loginId);

    User save(User user);

}
