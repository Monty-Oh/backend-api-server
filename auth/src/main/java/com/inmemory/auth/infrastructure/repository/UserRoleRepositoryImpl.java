package com.inmemory.auth.infrastructure.repository;

import com.inmemory.auth.domain.model.entity.UserRole;
import com.inmemory.auth.domain.repository.UserRoleRepository;
import com.inmemory.auth.infrastructure.repository.jpa.UserRoleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRoleRepositoryImpl implements UserRoleRepository {
    private final UserRoleJpaRepository userRoleJpaRepository;

    @Override
    public List<UserRole> findByUserRoleIdUserNo(String userNo) {
        return userRoleJpaRepository.findByUserRoleIdUserNo(userNo);
    }

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleJpaRepository.save(userRole);
    }

    @Override
    public List<UserRole> saveAll(List<UserRole> userRoles) {
        return userRoleJpaRepository.saveAll(userRoles);
    }
}
