package com.inmemory.content.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AlbumListRspDtoItem {
    private Long albumNo;

    private String imageUrl;

    private String title;

    private String description;

    private List<String> tagList;
}
