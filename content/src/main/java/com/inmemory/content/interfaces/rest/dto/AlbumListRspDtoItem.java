package com.inmemory.content.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public record AlbumListRspDtoItem (long contentId, String imageUrl, String title, String description){
}
