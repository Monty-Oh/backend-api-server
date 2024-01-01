package com.inmemory.content.domain.repository;

import com.inmemory.content.domain.aggregate.Content;

import java.util.Optional;

public interface ContentRepository {
    Optional<Content> findByContentNo(String contentNo);

    Content save(Content content);
}
