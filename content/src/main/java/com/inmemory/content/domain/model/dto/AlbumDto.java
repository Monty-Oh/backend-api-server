package com.inmemory.content.domain.model.dto;

import com.inmemory.content.domain.model.aggregate.Album;

public record AlbumDto(long contentId, String imageUrl, String title, String description) {

    public AlbumDto(Album album) {
        this(album.getContentId(), album.getImageUrl(), album.getTitle(), album.getDescription());
    }
}
