package com.inmemory.user.interfaces.rest.dto;

import lombok.Builder;

@Builder
public record UserLoginReqDto(String loginId, String password) {
}
