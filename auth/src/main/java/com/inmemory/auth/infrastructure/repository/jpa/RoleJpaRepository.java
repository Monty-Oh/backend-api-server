package com.inmemory.auth.infrastructure.repository.jpa;

import com.inmemory.auth.domain.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleJpaRepository extends JpaRepository<Role, Integer> {
    List<Role> findAllByIdIn(List<Integer> ids);
}
