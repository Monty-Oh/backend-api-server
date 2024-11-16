package com.inmemory.content.interfaces.rest.mapper;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.vo.AlbumListVo;
import com.inmemory.content.domain.model.vo.AlbumVo;
import com.inmemory.content.domain.model.query.AlbumListQuery;
import com.inmemory.content.interfaces.rest.dto.AlbumListRspDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AlbumListQueryMapperTest {
    private final AlbumListQueryMapper albumListQueryMapper = Mappers.getMapper(AlbumListQueryMapper.class);

    @Test
    void mapToQuery() {
        //  given
        String tagName = "testTag";

        //  when
        AlbumListQuery actual = albumListQueryMapper.mapToQuery(List.of(tagName));

        //  then
        assertAll(
                () -> assertThat(actual.getTagNameList().size()).isEqualTo(1),
                () -> assertThat(actual.getTagNameList().get(0)).isEqualTo(tagName)
        );
    }

    @Test
    void mapToRspDto() {
        //  given
        Album album = Album.builder()
                .contentId(0L)
                .title("testAlbum").build();
        AlbumListVo albumListVo = new AlbumListVo(List.of(new AlbumVo(album)));

        //  when
        AlbumListRspDto actual = albumListQueryMapper.mapToRspDto(albumListVo);

        //  then
        assertAll(
                () -> assertThat(actual.getAlbumList().size()).isEqualTo(1),
                () -> assertThat(actual.getAlbumList().get(0).getTitle()).isEqualTo(album.getTitle())
        );
    }
}