package com.inemory.user.infrastructure.repository;

import com.inemory.user.domain.model.aggregate.User;
import com.inemory.user.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends UserRepository, JpaRepository<User, String> {
}
