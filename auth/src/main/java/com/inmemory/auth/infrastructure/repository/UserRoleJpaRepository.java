package com.inmemory.auth.infrastructure.repository;

import com.inmemory.auth.domain.model.entity.UserRole;
import com.inmemory.auth.domain.model.entity.UserRoleId;
import com.inmemory.auth.domain.repository.UserRoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleJpaRepository extends UserRoleRepository, JpaRepository<UserRole, UserRoleId> {
}
