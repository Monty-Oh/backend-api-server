package com.inmemory.user.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class UserLoginReqDto {

    private String loginId;

    private String password;
}
