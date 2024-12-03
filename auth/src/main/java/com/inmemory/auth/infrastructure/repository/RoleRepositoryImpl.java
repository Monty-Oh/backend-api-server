package com.inmemory.auth.infrastructure.repository;

import com.inmemory.auth.domain.model.entity.Role;
import com.inmemory.auth.domain.repository.RoleRepository;
import com.inmemory.auth.infrastructure.repository.jpa.RoleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {
    private final RoleJpaRepository roleJpaRepository;

    @Override
    public List<Role> findAllByIdIn(List<Integer> ids) {
        return roleJpaRepository.findAllByIdIn(ids);
    }

    @Override
    public Role save(Role role) {
        return roleJpaRepository.save(role);
    }

    @Override
    public List<Role> saveAll(List<Role> roles) {
        return roleJpaRepository.saveAll(roles);
    }

    @Override
    public Role findById(int id) {
        return roleJpaRepository.findById(id).orElse(null);
    }
}
