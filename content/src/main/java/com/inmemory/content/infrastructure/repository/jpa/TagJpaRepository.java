package com.inmemory.content.infrastructure.repository.jpa;

import com.inmemory.content.domain.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagJpaRepository extends JpaRepository<Tag, Long> {
}
