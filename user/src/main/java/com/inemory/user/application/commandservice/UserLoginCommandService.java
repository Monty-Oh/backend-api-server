package com.inemory.user.application.commandservice;

import com.inemory.user.domain.model.command.UserLoginCommand;
import com.inemory.user.domain.service.UserVerifyPasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginCommandService {

    private final UserVerifyPasswordService userVerifyPasswordService;

    public Object login(UserLoginCommand userLoginCommand) {

    }
}
