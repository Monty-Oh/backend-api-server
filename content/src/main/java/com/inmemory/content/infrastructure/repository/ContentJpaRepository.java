package com.inmemory.content.infrastructure.repository;

import com.inmemory.content.domain.model.aggregate.Content;
import com.inmemory.content.domain.repository.ContentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentJpaRepository extends ContentRepository, JpaRepository<Content, String> {
}
