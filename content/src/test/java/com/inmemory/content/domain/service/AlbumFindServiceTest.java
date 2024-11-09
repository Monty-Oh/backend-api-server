package com.inmemory.content.domain.service;

import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.dto.AlbumDto;
import com.inmemory.content.domain.model.entity.Tag;
import com.inmemory.content.domain.repository.AlbumRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AlbumFindServiceTest {

    @InjectMocks
    private AlbumFindService albumFindService;

    @Mock
    private AlbumRepository albumRepository;

    @Test
    @DisplayName("앨범 리스트를 반환받는다. (태그 포함)")
    void getAlbumList() {
        //  given
        List<Tag> tagList = new ArrayList<>() {{
            add(Tag.builder().tagId(0L).tagName("tag1").build());
            add(Tag.builder().tagId(1L).tagName("tag2").build());
        }};
        List<Album> albumList = new ArrayList<>() {{
            add(Album.builder().contentId(0L).build());
            add(Album.builder().contentId(1L).build());
        }};
        given(albumRepository.findByTagList(anyList())).willReturn(albumList);

        //  when
        List<AlbumDto> actual = albumFindService.getAlbumList(tagList);

        //  then
        assertAll(
                () -> assertThat(actual).usingRecursiveComparison().isEqualTo(albumList)
        );
    }

    @Test
    @DisplayName("앨범 리스트를 반환받는다. (태그 미포함)")
    void getAlbumList_noTag() {
        //  given
        List<Tag> tagList = new ArrayList<>();
        List<Album> albumList = new ArrayList<>() {{
            add(Album.builder().contentId(0L).build());
            add(Album.builder().contentId(1L).build());
        }};
        given(albumRepository.findAll()).willReturn(albumList);

        //  when
        List<AlbumDto> actual = albumFindService.getAlbumList(tagList);

        //  then
        assertAll(
                () -> assertThat(actual).usingRecursiveComparison().isEqualTo(albumList)
        );
    }
}