package com.inemory.user.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLoginRspDto {

    private String accessToken;

    private String refreshToken;
}
