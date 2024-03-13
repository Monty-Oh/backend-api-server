package com.inmemory.auth.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCreateTokenReqDto {
    private String userNo;
}
