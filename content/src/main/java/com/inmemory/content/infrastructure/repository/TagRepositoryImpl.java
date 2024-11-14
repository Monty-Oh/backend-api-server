package com.inmemory.content.infrastructure.repository;

import com.inmemory.content.domain.model.entity.Tag;
import com.inmemory.content.domain.repository.TagRepository;
import com.inmemory.content.infrastructure.repository.jpa.TagJpaRepository;
import com.inmemory.content.infrastructure.repository.querydsl.TagCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TagRepositoryImpl implements TagRepository {
    private final TagJpaRepository tagJpaRepository;
    private final TagCustomRepository tagCustomRepository;

    @Override
    public List<Tag> findTagListByTagNameList(List<String> tagNameList) {
        return tagCustomRepository.findTagListByTagNameList(tagNameList);
    }

    @Override
    public List<Tag> saveAll(List<Tag> tags) {
        return tagJpaRepository.saveAll(tags);
    }
}
