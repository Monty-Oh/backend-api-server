package com.inmemory.user.infrastructure.feign.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCreateTokenReqDto {
    private String userNo;
}
