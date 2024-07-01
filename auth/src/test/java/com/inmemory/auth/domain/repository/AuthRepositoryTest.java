package com.inmemory.auth.domain.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AuthRepositoryTest {

    @Test
    @DisplayName("인증 정보 조회에 성공한다.")
    void auth_get_success() {

    }
}