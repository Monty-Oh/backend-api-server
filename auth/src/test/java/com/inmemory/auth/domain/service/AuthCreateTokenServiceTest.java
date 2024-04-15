package com.inmemory.auth.domain.service;

import com.inmemory.auth.common.utils.JwtUtils;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.domain.repository.AuthRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {""})
class AuthCreateTokenServiceTest {

    @InjectMocks
    private AuthCreateTokenService authCreateTokenService;

    @Mock
    private AuthRepository authRepository;
    @Mock
    private JwtUtils jwtUtils;

    @Test
    @DisplayName("액세스 토큰 발급에 성공한다.")
    void createTokenAndSaveRefreshToken_success() {
        //  given
        given(jwtUtils.createAccessToken(anyString())).willReturn("accessToken");
        given(jwtUtils.createRefreshToken(anyString())).willReturn("refreshToken");
        given(authRepository.findByUserNo(anyString())).willReturn(Optional.empty());

        //  when
        AuthCreateTokenVo actual = authCreateTokenService.createTokenAndSaveRefreshToken("testUserNo");

        //  then
        assertAll(
                () -> assertThat(actual.getAccessToken()).isEqualTo("accessToken"),
                () -> assertThat(actual.getRefreshToken()).isEqualTo("refreshToken")
        );
    }
}