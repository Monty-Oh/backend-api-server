package com.inmemory.user.infrastructure.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.RequestMethod;
import com.inmemory.user.infrastructure.feign.constants.AuthUrl;
import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenReqDto;
import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AuthFeignClientTest extends WireMockTest {

    @Autowired
    private AuthFeignClient authFeignClient;

    @Test
    @DisplayName("Auth 애플리케이션에게 토큰 생성 요청을 했고 성공했다.")
    void createAccessTokenAndRefreshToken_success() throws JsonProcessingException {
        //  given
        AuthCreateTokenRspDto authCreateTokenRspDto = AuthCreateTokenRspDto.builder()
                .accessToken("testAccessToken")
                .refreshToken("testRefreshToken")
                .build();
        setupSuccessResponse(RequestMethod.POST.value(), AuthUrl.AUTH_CREATE_TOKEN, authCreateTokenRspDto);

        AuthCreateTokenReqDto authCreateTokenReqDto = AuthCreateTokenReqDto.builder()
                .userNo("testUserNo")
                .build();

        //  when
        ResponseEntity<AuthCreateTokenRspDto> responseEntity = authFeignClient.createAccessTokenAndRefreshToken(authCreateTokenReqDto);

        //  then
        assertNotNull(responseEntity.getBody());
        AuthCreateTokenRspDto actual = responseEntity.getBody();
        assertAll(
                () -> assertThat(actual.getAccessToken()).isEqualTo(authCreateTokenRspDto.getAccessToken()),
                () -> assertThat(actual.getRefreshToken()).isEqualTo(authCreateTokenRspDto.getRefreshToken())
        );
    }

    @Test
    @DisplayName("Auth 애플리케이션에게 토큰 생성 요청을 했고 실패했다.")

}