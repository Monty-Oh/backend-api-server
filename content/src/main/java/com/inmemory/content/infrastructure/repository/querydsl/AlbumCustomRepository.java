package com.inmemory.content.infrastructure.repository.querydsl;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.entity.Tag;

import java.util.List;

public interface AlbumCustomRepository {

    /**
     * 선택된 태그 리스트로 선택된 앨범 리스트를 조회한다.
     *
     * @param tagList 태그 리스트
     * @return 앨범 조회 결과
     */
    List<Album> findByTagList(List<Tag> tagList);
}
