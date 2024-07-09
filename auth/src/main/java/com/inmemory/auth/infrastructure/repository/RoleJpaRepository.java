package com.inmemory.auth.infrastructure.repository;

import com.inmemory.auth.domain.model.entity.Role;
import com.inmemory.auth.domain.repository.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends RoleRepository, JpaRepository<Role, Integer> {
}
