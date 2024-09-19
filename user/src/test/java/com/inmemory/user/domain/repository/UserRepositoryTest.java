package com.inmemory.user.domain.repository;

import com.inmemory.user.domain.model.aggregate.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("user 조회에 성공한다.")
    void user_get_success() {
        //  given
        User user = User.builder()
                .userId(1)
                .userNo("testUserNo")
                .loginId("testLoginId")
                .build();
        userRepository.save(user);

        //  when
        Optional<User> result = userRepository.findByUserNo(user.getUserNo());

        //  then
        assertTrue(result.isPresent());
        User actual = result.get();
        assertThat(actual.getUserNo()).isEqualTo(user.getUserNo());
        assertThat(actual.getUserId()).isEqualTo(user.getUserId());
        assertThat(actual.getLoginId()).isEqualTo(user.getLoginId());
    }
}