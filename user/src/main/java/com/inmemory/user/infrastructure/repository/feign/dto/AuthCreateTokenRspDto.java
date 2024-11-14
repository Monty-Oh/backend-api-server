package com.inmemory.user.infrastructure.repository.feign.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCreateTokenRspDto {
    private String accessToken;

    private String refreshToken;
}
