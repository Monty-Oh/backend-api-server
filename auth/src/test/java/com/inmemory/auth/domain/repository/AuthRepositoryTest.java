package com.inmemory.auth.domain.repository;

import com.inmemory.auth.domain.model.aggregate.Auth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AuthRepositoryTest {

    @Autowired
    private AuthRepository authRepository;

    @Test
    @DisplayName("인증 정보 조회에 성공한다.")
    void auth_get_success() {
        //  given
        Auth auth = Auth.builder()
                .userNo("testUserNo")
                .refreshToken("testRefreshToken")
                .build();
        authRepository.save(auth);

        //  when
        Optional<Auth> result = authRepository.findByUserNo(auth.getUserNo());

        //  then
        assertTrue(result.isPresent());
        Auth actual = result.get();
        assertAll(
                () -> assertThat(actual.getUserNo()).isEqualTo(auth.getUserNo()),
                () -> assertThat(actual.getRefreshToken()).isEqualTo(auth.getRefreshToken())
        );
    }
}