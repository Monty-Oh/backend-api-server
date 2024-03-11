package com.inemory.user.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLoginReqDto {

    private String loginId;

    private String password;
}
