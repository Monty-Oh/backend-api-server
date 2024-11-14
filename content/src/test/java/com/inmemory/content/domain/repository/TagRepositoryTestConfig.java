package com.inmemory.content.domain.repository;

import com.inmemory.content.infrastructure.repository.TagRepositoryImpl;
import com.inmemory.content.infrastructure.repository.jpa.TagJpaRepository;
import com.inmemory.content.infrastructure.repository.querydsl.TagCustomRepository;
import com.inmemory.content.infrastructure.repository.querydsl.TagCustomRepositoryImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TagRepositoryTestConfig {
    @Bean
    public TagCustomRepository tagCustomRepository(JPAQueryFactory jpaQueryFactory) {
        return new TagCustomRepositoryImpl(jpaQueryFactory);
    }

    @Bean
    public TagRepository tagRepository(TagJpaRepository tagJpaRepository, TagCustomRepository tagCustomRepository) {
        return new TagRepositoryImpl(tagJpaRepository, tagCustomRepository);
    }
}
