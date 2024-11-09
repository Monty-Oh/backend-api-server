package com.inmemory.content.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AlbumListRspDtoItem {
    private long contentId;

    private String imageUrl;

    private String title;

    private String description;
}
