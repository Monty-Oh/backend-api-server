package com.inmemory.content.domain.repository;

import com.inmemory.content.domain.model.aggregate.Content;

import java.util.Optional;

public interface ContentRepository {
    Optional<Content> findByContentId(long contentId);

    Content save(Content content);
}
