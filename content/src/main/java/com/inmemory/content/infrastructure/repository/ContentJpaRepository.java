package com.inmemory.content.infrastructure.repository;

import com.inmemory.content.domain.aggregate.Content;
import com.inmemory.content.domain.repository.ContentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentJpaRepository extends ContentRepository, JpaRepository<Content, String> {
    Optional<Content> findByContentNo(String contentNo);
}
