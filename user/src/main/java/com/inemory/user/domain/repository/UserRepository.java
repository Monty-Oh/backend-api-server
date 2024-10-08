package com.inemory.user.domain.repository;

import com.inemory.user.domain.aggregate.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUserNo(String userNo);

    User save(User user);

}
