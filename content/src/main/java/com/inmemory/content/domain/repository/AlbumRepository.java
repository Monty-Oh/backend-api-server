package com.inmemory.content.domain.repository;

import com.inmemory.content.infrastructure.repository.AlbumCustomRepository;
import com.inmemory.content.infrastructure.repository.AlbumJpaRepository;

public interface AlbumRepository extends AlbumJpaRepository, AlbumCustomRepository {
}
