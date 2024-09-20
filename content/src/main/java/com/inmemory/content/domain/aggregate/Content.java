package com.inmemory.content.domain.aggregate;

import com.inmemory.content.domain.entity.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "content")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    @Column(name = "content_no")
    private String contentNo;

    @ManyToMany
    @JoinTable(
            name = "content_tag",
            joinColumns = @JoinColumn(name = "content_no", referencedColumnName = "content_no"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    )
    private Set<Tag> tags;
}
