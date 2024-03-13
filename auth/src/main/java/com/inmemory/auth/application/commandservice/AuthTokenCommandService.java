package com.inmemory.auth.application.commandservice;

import com.inmemory.auth.domain.model.command.AuthCreateTokenCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthTokenCommandService {

    public Object createToken(AuthCreateTokenCommand authCreateTokenCommand) {

    }
}
