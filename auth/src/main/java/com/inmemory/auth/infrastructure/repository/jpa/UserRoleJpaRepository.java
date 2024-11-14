package com.inmemory.auth.infrastructure.repository.jpa;

import com.inmemory.auth.domain.model.entity.UserRole;
import com.inmemory.auth.domain.model.entity.UserRoleId;
import com.inmemory.auth.domain.repository.UserRoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleJpaRepository extends JpaRepository<UserRole, UserRoleId> {
    List<UserRole> findByUserRoleIdUserNo(String userNo);
}
