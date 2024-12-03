package com.inmemory.user.domain.model.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLoginCommand {

    private String loginId;

    private String password;
}
