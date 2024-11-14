package com.inmemory.content.domain.repository;

import com.inmemory.content.infrastructure.repository.AlbumRepositoryImpl;
import com.inmemory.content.infrastructure.repository.jpa.AlbumJpaRepository;
import com.inmemory.content.infrastructure.repository.querydsl.AlbumCustomRepository;
import com.inmemory.content.infrastructure.repository.querydsl.AlbumCustomRepositoryImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class AlbumRepositoryTestConfig {
    @Bean
    public AlbumCustomRepository albumCustomRepository(JPAQueryFactory jpaQueryFactory) {
        return new AlbumCustomRepositoryImpl(jpaQueryFactory);
    }

    @Bean
    public AlbumRepository albumRepository(AlbumJpaRepository albumJpaRepository, AlbumCustomRepository albumCustomRepository) {
        return new AlbumRepositoryImpl(albumJpaRepository, albumCustomRepository);
    }
}
