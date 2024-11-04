package com.inmemory.content.domain.model.dto;

import com.inmemory.content.domain.model.aggregate.Album;

public record AlbumDto(long albumNo, String imageUrl, String title, String description) {

    public AlbumDto(Album album) {
        this(album.getAlbumNo(), album.getImageUrl(), album.getTitle(), album.getDescription());
    }
}
