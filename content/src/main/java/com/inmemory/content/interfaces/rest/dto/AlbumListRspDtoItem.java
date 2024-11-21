package com.inmemory.content.interfaces.rest.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record AlbumListRspDtoItem (long contentId, String imageUrl, String title, String description, List<String> tagNameList) {
}
