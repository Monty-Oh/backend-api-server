package com.inmemory.content.interfaces.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inmemory.content.application.queryservice.AlbumListQueryService;
import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.entity.Tag;
import com.inmemory.content.domain.model.vo.AlbumListVo;
import com.inmemory.content.domain.model.vo.AlbumVo;
import com.inmemory.content.domain.model.query.AlbumListQuery;
import com.inmemory.content.interfaces.rest.constants.ContentApiUrl;
import com.inmemory.content.interfaces.rest.dto.AlbumListRspDto;
import com.inmemory.content.interfaces.rest.dto.AlbumListRspDtoItem;
import com.inmemory.content.interfaces.rest.mapper.AlbumListQueryMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AlbumController.class)
class AlbumControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlbumListQueryService albumListQueryService;

    @MockBean
    private AlbumListQueryMapper albumListQueryMapper;

    @Test
    @DisplayName("앨범 컨텐츠 조회를 요청했고, 성공 응답이 온다.")
    void getAlbumList() throws Exception {
        //  given
        String tagName = "testTag";
        AlbumListQuery albumListQuery = AlbumListQuery.builder()
                .tagNameList(List.of(tagName))
                .build();
        given(albumListQueryMapper.mapToQuery(anyList())).willReturn(albumListQuery);

        Tag tag = Tag.builder()
                .tagName("testTag")
                .tagId(0L)
                .build();
        Album album = Album.builder()
                .contentId(0L)
                .title("testTitle")
                .tags(new HashSet<>(List.of(tag)))
                .build();
        AlbumListVo albumListVo = new AlbumListVo(List.of(new AlbumVo(album)));
        given(albumListQueryService.getAlbumList(any())).willReturn(albumListVo);

        AlbumListRspDto albumListRspDto = AlbumListRspDto.builder()
                .albumList(List.of(
                        AlbumListRspDtoItem
                                .builder()
                                .title("testTitle")
                                .build()
                ))
                .build();
        given(albumListQueryMapper.mapToRspDto(any())).willReturn(albumListRspDto);

        //  when,   then
        mockMvc.perform(
                        MockMvcRequestBuilders.get(ContentApiUrl.CONTENT_V1_BASE_URL + ContentApiUrl.ALBUM_LIST)
                                .queryParam("tag", tagName)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(albumListRspDto)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}