package com.inmemory.auth.domain.model.vo;

import lombok.Builder;

@Builder
public record AuthCreateTokenVo(String accessToken, String refreshToken) {
}
