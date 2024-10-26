package com.inmemory.auth.domain.repository;

import com.inmemory.auth.domain.model.entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository {

    List<UserRole> findByUserRoleIdUserNo(String userNo);

    UserRole save(UserRole userRole);
}
