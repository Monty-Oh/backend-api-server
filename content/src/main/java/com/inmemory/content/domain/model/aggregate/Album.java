package com.inmemory.content.domain.model.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "content_album")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Album extends Content {

    @Column(name = "album_no")
    private Long albumNo;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
