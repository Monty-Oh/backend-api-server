package com.inmemory.content.application.queryservice;

import com.inmemory.content.domain.model.dto.AlbumDto;
import com.inmemory.content.domain.model.dto.AlbumListDto;
import com.inmemory.content.domain.model.entity.Tag;
import com.inmemory.content.domain.model.query.AlbumListQuery;
import com.inmemory.content.domain.service.AlbumFindService;
import com.inmemory.content.domain.service.TagFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumListQueryService {
    private final AlbumFindService albumFindService;
    private final TagFindService tagFindService;

    /**
     * 앨범 리스트를 반환한다.
     *
     * @return 컨텐츠 리스트
     */
    public AlbumListDto getAlbumList(AlbumListQuery albumListQuery) {
        List<Tag> tagList = tagFindService.findTagList(albumListQuery.getTagNameList());
        List<AlbumDto> albumDtoList = albumFindService.getAlbumList(tagList);
        return new AlbumListDto(albumDtoList);
    }
}
