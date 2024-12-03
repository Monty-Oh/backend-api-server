package com.inmemory.content.domain.model.vo;

import com.inmemory.content.domain.model.entity.Tag;

public record TagVo(long tagId, String tagName) {
    public TagVo(Tag tag) {
        this(tag.getTagId(), tag.getTagName());
    }
}
