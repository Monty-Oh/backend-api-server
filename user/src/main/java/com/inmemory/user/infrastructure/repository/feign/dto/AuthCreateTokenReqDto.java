package com.inmemory.user.infrastructure.repository.feign.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCreateTokenReqDto {
    private String userNo;
}
