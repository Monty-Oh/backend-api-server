package com.inmemory.auth.domain.model.vo;

import lombok.Builder;

@Builder
public record AuthRefreshTokenVo(String accessToken, String refreshToken) {
}
