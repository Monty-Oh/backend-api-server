package com.inmemory.auth.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthRefreshTokenReqDto {

    private String accessToken;

    private String refreshToken;
}
