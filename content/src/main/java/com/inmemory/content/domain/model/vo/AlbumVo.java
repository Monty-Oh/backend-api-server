package com.inmemory.content.domain.model.vo;

import com.inmemory.content.domain.model.aggregate.Album;

public record AlbumVo(long contentId, String imageUrl, String title, String description) {

    public AlbumVo(Album album) {
        this(album.getContentId(), album.getImageUrl(), album.getTitle(), album.getDescription());
    }
}
