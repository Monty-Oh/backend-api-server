package com.inmemory.content.domain.service;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.dto.AlbumDto;
import com.inmemory.content.domain.model.entity.Tag;
import com.inmemory.content.domain.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumFindService {
    private final AlbumRepository albumRepository;

    /**
     * 앨범 리스트를 반환한다.
     *
     * @return 컨텐츠 리스트
     */
    public List<AlbumDto> getAlbumList(List<Tag> tagList) {
        List<Album> albumList = tagList.isEmpty()
                ? albumRepository.findAll()
                : albumRepository.findByTagList(tagList);
        return albumList.stream()
                .map(AlbumDto::new)
                .toList();
    }
}
