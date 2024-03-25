package com.inmemory.user.infrastructure.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenReqDto;
import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

class AuthFeignClientTest extends WireMockTest{

    private final WireMockServer wireMockServer = new WireMockServer();

    @Autowired
    private AuthFeignClient authFeignClient;

    @Test
    @DisplayName("test...")
    void createAccessTokenAndRefreshToken_success() throws JsonProcessingException {
        AuthCreateTokenRspDto authCreateTokenRspDto = AuthCreateTokenRspDto.builder()
                .accessToken("testAccessToken")
                .refreshToken("testRefreshToken")
                .build();
        setupPostSuccessResponse(wireMockServer, authCreateTokenRspDto);

        ResponseEntity<AuthCreateTokenRspDto> accessTokenAndRefreshToken = authFeignClient.createAccessTokenAndRefreshToken(
                AuthCreateTokenReqDto.builder().build()
        );

        System.out.println("accessTokenAndRefreshToken = " + accessTokenAndRefreshToken);

    }
}