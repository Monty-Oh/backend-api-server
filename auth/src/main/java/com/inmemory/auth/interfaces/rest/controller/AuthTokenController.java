package com.inmemory.auth.interfaces.rest.controller;

import com.inmemory.auth.application.commandservice.AuthTokenCommandService;
import com.inmemory.auth.domain.model.command.AuthCreateTokenCommand;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenReqDto;
import com.inmemory.auth.interfaces.rest.mapper.AuthCreateTokenCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.inmemory.auth.interfaces.rest.constants.AuthApiUrl.AUTH_CREATE_TOKEN;
import static com.inmemory.auth.interfaces.rest.constants.AuthApiUrl.AUTH_V1_BASE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH_V1_BASE_URL)
public class AuthTokenController {

    private final AuthTokenCommandService authTokenCommandService;

    private final AuthCreateTokenCommandMapper authCreateTokenCommandMapper;

    @PostMapping(AUTH_CREATE_TOKEN)
    public ResponseEntity<Object> createToken(AuthCreateTokenReqDto authCreateTokenReqDto) {
        AuthCreateTokenCommand authCreateTokenCommand = authCreateTokenCommandMapper.mapToCommand(authCreateTokenReqDto);


        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
