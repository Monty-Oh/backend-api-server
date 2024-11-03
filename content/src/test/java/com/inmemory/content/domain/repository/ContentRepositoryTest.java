package com.inmemory.content.domain.repository;

import com.inmemory.content.domain.model.aggregate.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ContentRepositoryTest {

    @Autowired
    ContentRepository contentRepository;

    @Test
    @DisplayName("Content 조회에 성공한다.")
    void content_get_success() {
        //  given
        Content content = Content.builder()
                .contentId(1L)
                .build();
        contentRepository.save(content);

        //  when
        Optional<Content> result = contentRepository.findByContentId(content.getContentId());

        //  then
        assertTrue(result.isPresent());
        Content actual = result.get();
        assertThat(actual.getContentId()).isEqualTo(content.getContentId());
    }
}