package com.inmemory.auth.domain.repository;

import com.inmemory.auth.domain.model.entity.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> findByIdIn(List<Integer> ids);
}
