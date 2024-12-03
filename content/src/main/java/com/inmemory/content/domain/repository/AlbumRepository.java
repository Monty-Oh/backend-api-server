package com.inmemory.content.domain.repository;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.entity.Tag;

import java.util.List;

public interface AlbumRepository {

    List<Album> findAll();

    List<Album> findByTagList(List<Tag> tags);

    Album save(Album album);

    List<Album> saveAll(List<Album> albums);
}
