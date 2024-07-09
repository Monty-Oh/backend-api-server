package com.inmemory.user.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLoginRspDto {

    private String accessToken;

    private String refreshToken;
}
