package com.inmemory.user.domain.service;

import com.inmemory.user.common.constants.ErrorCode;
import com.inmemory.user.common.exception.ApplicationException;
import com.inmemory.user.domain.model.aggregate.User;
import com.inmemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.user.domain.repository.AuthRepository;
import com.inmemory.user.domain.repository.UserRepository;
import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import com.inmemory.user.infrastructure.feign.mapper.AuthCreateTokenVoMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AuthCreateTokenServiceTest {
    @InjectMocks
    private AuthCreateTokenService authCreateTokenService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private AuthRepository authRepository;
    @Mock
    private AuthCreateTokenVoMapper authCreateTokenVoMapper;

    @Test
    @DisplayName("토큰 정보 생성 요청에 성공했다.")
    void getUserNoAndCreateToken_success() {
        //  given
        User user = User.builder()
                .userNo("testUserNo")
                .build();
        given(userRepository.findByLoginId(anyString())).willReturn(Optional.of(user));
        AuthCreateTokenRspDto authCreateTokenRspDto = AuthCreateTokenRspDto.builder()
                .accessToken("testAccessToken")
                .refreshToken("testRefreshToken")
                .build();
        given(authRepository.createAccessTokenAndRefreshToken(anyString())).willReturn(ResponseEntity.of(Optional.of(authCreateTokenRspDto)));
        AuthCreateTokenVo authCreateTokenVo = AuthCreateTokenVo.builder()
                .accessToken(authCreateTokenRspDto.getAccessToken())
                .refreshToken(authCreateTokenRspDto.getRefreshToken())
                .build();
        given(authCreateTokenVoMapper.mapToVo(any())).willReturn(authCreateTokenVo);

        //  when
        AuthCreateTokenVo actual = authCreateTokenService.getUserNoAndCreateToken("testLoginId");

        //  then
        assertAll(
                () -> assertThat(actual.getAccessToken()).isEqualTo(authCreateTokenVo.getAccessToken()),
                () -> assertThat(actual.getRefreshToken()).isEqualTo(authCreateTokenVo.getRefreshToken())
        );
    }

    @Test
    @DisplayName("회원 정보가 존재하지 않는다.")
    void getUserNoAndCreateToken_not_found_user_info() {
        //  when,   then
        ApplicationException actual = assertThrows(ApplicationException.class, () -> authCreateTokenService.getUserNoAndCreateToken("testLoginId"));
        assertAll(
                () -> assertThat(actual.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND_USER_INFO.getCode()),
                () -> assertThat(actual.getMessage()).isEqualTo(ErrorCode.NOT_FOUND_USER_INFO.getMessage())
        );
    }

    @Test
    @DisplayName("토큰 정보가 비정상적이다.")
    void getUserNoAndCreateToken_invalid_token_info() {
        //  given
        User user = User.builder()
                .userNo("testUserNo")
                .build();
        given(userRepository.findByLoginId(anyString())).willReturn(Optional.of(user));
        given(authRepository.createAccessTokenAndRefreshToken(anyString())).willReturn(ResponseEntity.of(Optional.empty()));

        //  when,   then
        ApplicationException actual = assertThrows(ApplicationException.class, () -> authCreateTokenService.getUserNoAndCreateToken("testLoginId"));
        assertAll(
                () -> assertThat(actual.getErrorCode()).isEqualTo(ErrorCode.EXTERNAL_SERVER_ERROR.getCode()),
                () -> assertThat(actual.getMessage()).isEqualTo(ErrorCode.EXTERNAL_SERVER_ERROR.getMessage())
        );
    }
}