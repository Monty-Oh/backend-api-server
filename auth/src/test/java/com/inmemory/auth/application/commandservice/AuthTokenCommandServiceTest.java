package com.inmemory.auth.application.commandservice;

import com.inmemory.auth.domain.model.command.AuthCreateTokenCommand;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.domain.service.AuthCreateTokenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class AuthTokenCommandServiceTest {
    @InjectMocks
    AuthTokenCommandService authTokenCommandService;

    @Mock
    AuthCreateTokenService authCreateTokenService;

    @Test
    @DisplayName("토큰 생성 비즈니스 로직을 수행한다.")
    void createToken() {
        //  given
        AuthCreateTokenCommand authCreateTokenCommand = AuthCreateTokenCommand.builder()
                .userNo("testUserNo")
                .build();
        AuthCreateTokenVo authCreateTokenVo = AuthCreateTokenVo.builder()
                .accessToken("testAccessToken")
                .refreshToken("testRefreshToken")
                .build();
        given(authCreateTokenService.createTokenAndSaveRefreshToken(any())).willReturn(authCreateTokenVo);

        //  when
        AuthCreateTokenVo actual = authTokenCommandService.createToken(authCreateTokenCommand);

        //  then
        assertAll(
                () -> assertThat(actual.getAccessToken()).isEqualTo(authCreateTokenVo.getAccessToken()),
                () -> assertThat(actual.getRefreshToken()).isEqualTo(authCreateTokenVo.getRefreshToken())
        );
    }
}