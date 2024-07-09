package com.inmemory.auth.domain.model.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCreateTokenVo {

    private String accessToken;

    private String refreshToken;
}
