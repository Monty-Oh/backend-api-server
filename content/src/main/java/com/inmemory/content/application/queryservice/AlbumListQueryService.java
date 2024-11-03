package com.inmemory.content.application.queryservice;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.query.AlbumListQuery;
import com.inmemory.content.domain.repository.AlbumCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumListQueryService {
    private final AlbumCustomRepository albumCustomRepository;

    /**
     * 앨범 리스트를 반환한다.
     *
     * @return 컨텐츠 리스트
     */
    public List<Album> getAlbumList(AlbumListQuery albumListQuery) {
        return albumCustomRepository.findByTagList(albumListQuery.getTagList());
    }
}
