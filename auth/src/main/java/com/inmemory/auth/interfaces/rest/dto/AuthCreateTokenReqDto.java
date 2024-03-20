package com.inmemory.auth.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthCreateTokenReqDto {
    private String userNo;
}
