package com.inmemory.content.infrastructure.repository.jpa;

import com.inmemory.content.domain.model.aggregate.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumJpaRepository extends JpaRepository<Album, Long> {

}
