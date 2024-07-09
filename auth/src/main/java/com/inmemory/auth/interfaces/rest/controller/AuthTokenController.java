package com.inmemory.auth.interfaces.rest.controller;

import com.inmemory.auth.application.commandservice.AuthTokenCommandService;
import com.inmemory.auth.domain.model.command.AuthCreateTokenCommand;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenReqDto;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenRspDto;
import com.inmemory.auth.interfaces.rest.mapper.AuthCreateTokenCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 토큰 생성 API
     *
     * @param authCreateTokenReqDto 토큰 생성 요청 Dto
     * @return 토큰 생성 결과
     */
    @PostMapping(value = AUTH_CREATE_TOKEN, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthCreateTokenRspDto> createToken(@RequestBody AuthCreateTokenReqDto authCreateTokenReqDto) {
        AuthCreateTokenCommand authCreateTokenCommand = authCreateTokenCommandMapper.mapToCommand(authCreateTokenReqDto);
        AuthCreateTokenVo authCreateTokenVo = authTokenCommandService.createToken(authCreateTokenCommand);
        AuthCreateTokenRspDto authCreateTokenRspDto = authCreateTokenCommandMapper.mapToRspDto(authCreateTokenVo);
        return new ResponseEntity<>(authCreateTokenRspDto, HttpStatus.OK);
    }
}
