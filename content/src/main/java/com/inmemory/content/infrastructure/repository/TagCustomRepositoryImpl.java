package com.inmemory.content.infrastructure.repository;

import com.inmemory.content.domain.model.entity.Tag;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.inmemory.content.domain.model.entity.QTag.tag;

@Repository
public class TagCustomRepositoryImpl extends QuerydslRepositorySupport implements TagCustomRepository {

    private JPAQueryFactory queryFactory;

    public TagCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Tag.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Tag> findTagListByTagNameList(List<String> tagList) {
        return queryFactory.selectFrom(tag)
                .where(tag.tagName.in(tagList))
                .fetch();
    }
}
