package com.inmemory.user.infrastructure.repository;

import com.inmemory.user.domain.model.aggregate.User;
import com.inmemory.user.domain.repository.UserRepository;
import com.inmemory.user.infrastructure.repository.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findByUserNo(String userNo) {
        return userJpaRepository.findByUserNo(userNo);
    }

    @Override
    public Optional<User> findByLoginId(String loginId) {
        return userJpaRepository.findByLoginId(loginId);
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }
}
