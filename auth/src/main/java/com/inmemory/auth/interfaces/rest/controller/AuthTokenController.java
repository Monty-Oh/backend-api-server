package com.inmemory.auth.interfaces.rest.controller;

import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenReqDto;
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

    @PostMapping(AUTH_CREATE_TOKEN)
    public ResponseEntity<Object> createToken(AuthCreateTokenReqDto authCreateTokenReqDto) {

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
