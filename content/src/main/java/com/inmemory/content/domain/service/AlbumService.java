package com.inmemory.content.domain.service;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.dto.AlbumDto;
import com.inmemory.content.domain.repository.AlbumCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumCustomRepository albumCustomRepository;

    /**
     * 앨범 리스트를 반환한다.
     *
     * @return 컨텐츠 리스트
     */
    public List<AlbumDto> getAlbumList(List<String> tagList) {
        List<Album> albumList = albumCustomRepository.findByTagList(tagList);
        return albumList.stream()
                .map(AlbumDto::new)
                .toList();
    }
}
