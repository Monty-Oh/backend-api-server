package com.inmemory.content.interfaces.rest.mapper;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.dto.AlbumDto;
import com.inmemory.content.domain.model.dto.AlbumListDto;
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
        AlbumListDto albumListDto = new AlbumListDto(List.of(new AlbumDto(album)));

        //  when
        AlbumListRspDto actual = albumListQueryMapper.mapToRspDto(albumListDto);

        //  then
        assertAll(
                () -> assertThat(actual.getAlbumList().size()).isEqualTo(1),
                () -> assertThat(actual.getAlbumList().get(0).getTitle()).isEqualTo(album.getTitle())
        );
    }
}