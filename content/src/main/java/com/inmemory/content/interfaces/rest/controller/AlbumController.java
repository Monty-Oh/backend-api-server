package com.inmemory.content.interfaces.rest.controller;

import com.inmemory.content.application.queryservice.AlbumListQueryService;
import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.query.AlbumListQuery;
import com.inmemory.content.interfaces.rest.constants.ContentApiUrl;
import com.inmemory.content.interfaces.rest.mapper.AlbumListQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ContentApiUrl.CONTENT_V1_BASE_URL)
public class AlbumController {
    private final AlbumListQueryService albumListQueryService;
    private final AlbumListQueryMapper albumListQueryMapper;

    /**
     * 앨범 컨텐츠 리스트 조회
     *
     * @param tagList 조회하고 싶은 Tag
     * @return 조회 결과
     */
    @GetMapping(ContentApiUrl.ALBUM_LIST)
    public ResponseEntity<Object> getAlbumList(@RequestParam(value = "tag") List<String> tagList) {
        AlbumListQuery albumListQuery = albumListQueryMapper.mapToQuery(tagList);
        List<Album> albumList = albumListQueryService.getAlbumList(albumListQuery);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
