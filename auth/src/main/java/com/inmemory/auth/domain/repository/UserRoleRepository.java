package com.inmemory.auth.domain.repository;

import com.inmemory.auth.domain.model.entity.UserRole;

import java.util.List;

public interface UserRoleRepository {

    List<UserRole> findByUserRoleIdUserNo(String userNo);
}
