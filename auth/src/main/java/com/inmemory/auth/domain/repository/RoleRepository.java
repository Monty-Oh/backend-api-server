package com.inmemory.auth.domain.repository;

import com.inmemory.auth.domain.model.entity.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> findAllByIdIn(List<Integer> ids);

    Role save(Role role);

    List<Role> saveAll(List<Role> roles);

    Role findById(int id);
}
