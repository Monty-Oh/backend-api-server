package com.inemory.user.infrastructure.feign.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCreateTokenRspDto {
    private String accessToken;

    private String refreshToken;
}
