package com.inmemory.content.infrastructure.repository.querydsl;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.entity.Tag;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.inmemory.content.domain.model.aggregate.QAlbum.album;

@Repository
public class AlbumCustomRepositoryImpl extends QuerydslRepositorySupport implements AlbumCustomRepository {

    private final JPAQueryFactory queryFactory;

    public AlbumCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Album.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Album> findByTagList(List<Tag> tagList) {
        return queryFactory
                .selectFrom(album)
                .where(
                        album.tags
                                .any()
                                .in(tagList)
                )
                .fetch();
    }
}
