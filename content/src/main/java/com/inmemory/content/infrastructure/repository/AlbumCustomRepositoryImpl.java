package com.inmemory.content.infrastructure.repository;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.repository.AlbumCustomRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumCustomRepositoryImpl extends QuerydslRepositorySupport implements AlbumCustomRepository {

    public AlbumCustomRepositoryImpl() {
        super(Album.class);
    }

    @Override
    public List<Album> findByTagList(List<String> tagList) {
        return List.of();
    }
}
