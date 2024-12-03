package com.inmemory.auth.interfaces.rest.controller;

import com.inmemory.auth.application.commandservice.AuthTokenCommandService;
import com.inmemory.auth.common.constants.CustomHeaders;
import com.inmemory.auth.domain.model.command.AuthCreateTokenCommand;
import com.inmemory.auth.domain.model.command.AuthRefreshTokenCommand;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.domain.model.vo.AuthRefreshTokenVo;
import com.inmemory.auth.interfaces.rest.constants.AuthApiUrl;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenReqDto;
import com.inmemory.auth.interfaces.rest.dto.AuthCreateTokenRspDto;
import com.inmemory.auth.interfaces.rest.dto.AuthRefreshTokenRspDto;
import com.inmemory.auth.interfaces.rest.mapper.AuthCreateTokenCommandMapper;
import com.inmemory.auth.interfaces.rest.mapper.AuthRefreshTokenCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AuthApiUrl.AUTH_V1_BASE_URL)
public class AuthTokenController {

    private final AuthTokenCommandService authTokenCommandService;

    private final AuthCreateTokenCommandMapper authCreateTokenCommandMapper;
    private final AuthRefreshTokenCommandMapper authRefreshTokenCommandMapper;

    /**
     * 토큰 생성 API
     *
     * @param authCreateTokenReqDto 토큰 생성 요청 Dto
     * @return 토큰 생성 결과
     */
    @PostMapping(value = AuthApiUrl.AUTH_CREATE_TOKEN, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthCreateTokenRspDto> createToken(@RequestBody AuthCreateTokenReqDto authCreateTokenReqDto) {
        AuthCreateTokenCommand authCreateTokenCommand = authCreateTokenCommandMapper.mapToCommand(authCreateTokenReqDto);
        AuthCreateTokenVo authCreateTokenVo = authTokenCommandService.createToken(authCreateTokenCommand);
        AuthCreateTokenRspDto authCreateTokenRspDto = authCreateTokenCommandMapper.mapToRspDto(authCreateTokenVo);
        return new ResponseEntity<>(authCreateTokenRspDto, HttpStatus.OK);
    }

    /**
     * 토큰 갱신 API
     *
     * @param refreshToken 토큰 갱신에 필요한 refreshToken (Header)
     * @return 토큰 갱신 결과
     */
    @PutMapping(value = AuthApiUrl.AUTH_REFRESH_TOKEN, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthRefreshTokenRspDto> refreshToken(@RequestHeader(CustomHeaders.REFRESH_TOKEN) String refreshToken) {
        AuthRefreshTokenCommand authRefreshTokenCommand = authRefreshTokenCommandMapper.mapToCommand(refreshToken);
        AuthRefreshTokenVo authRefreshTokenVo = authTokenCommandService.refreshToken(authRefreshTokenCommand);
        AuthRefreshTokenRspDto authRefreshTokenRspDto = authRefreshTokenCommandMapper.mapToRspDto(authRefreshTokenVo);
        return new ResponseEntity<>(authRefreshTokenRspDto, HttpStatus.OK);
    }
}
