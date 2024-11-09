package com.inmemory.content.infrastructure.repository;

import com.inmemory.content.domain.model.entity.Tag;

import java.util.List;

public interface TagCustomRepository {

    List<Tag> findTagListByTagNameList(List<String> tagList);
}
