package com.inmemory.content.domain.repository;

import com.inmemory.content.infrastructure.repository.TagCustomRepository;
import com.inmemory.content.infrastructure.repository.TagJpaRepository;

public interface TagRepository extends TagJpaRepository, TagCustomRepository {
}
