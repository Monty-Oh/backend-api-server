package com.inmemory.content.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AlbumListRspDto {

    private List<AlbumListRspDtoItem> albumList;
}
