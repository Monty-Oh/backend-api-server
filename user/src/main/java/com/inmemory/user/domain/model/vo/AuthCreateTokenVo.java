package com.inmemory.user.domain.model.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCreateTokenVo {

    private String accessToken;

    private String refreshToken;
}
