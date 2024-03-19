package com.inmemory.user.application.commandservice;

import com.inmemory.user.domain.model.command.UserLoginCommand;
import com.inmemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.user.domain.service.AuthCreateTokenService;
import com.inmemory.user.domain.service.UserVerifyPasswordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserLoginCommandServiceTest {
    @InjectMocks
    private UserLoginCommandService userLoginCommandService;

    @Mock
    private UserVerifyPasswordService userVerifyPasswordService;

    @Mock
    private AuthCreateTokenService authCreateTokenService;

    @Test
    @DisplayName("로그인 애플리케이션 서비스 호출을 한다.")
    void login() {
        //  given
        AuthCreateTokenVo authCreateTokenVo = AuthCreateTokenVo.builder()
                .accessToken("testAccessToken")
                .refreshToken("testRefreshToken")
                .build();
        given(authCreateTokenService.getUserNoAndCreateToken(anyString())).willReturn(authCreateTokenVo);
        UserLoginCommand userLoginCommand = UserLoginCommand.builder()
                .loginId("testLoginId")
                .password("testPassword")
                .build();

        //  when
        AuthCreateTokenVo actual = userLoginCommandService.login(userLoginCommand);

        //  then
        assertAll(
                () -> assertThat(actual.getAccessToken()).isEqualTo(authCreateTokenVo.getAccessToken()),
                () -> assertThat(actual.getRefreshToken()).isEqualTo(authCreateTokenVo.getRefreshToken()),
                () -> verify(userVerifyPasswordService, times(1)).verifyPassword(anyString(), anyString())
        );
    }
}