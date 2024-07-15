package com.inmemory.auth.application.commandservice;

import com.inmemory.auth.domain.model.command.AuthCreateTokenCommand;
import com.inmemory.auth.domain.model.command.AuthRefreshTokenCommand;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.domain.model.vo.AuthRefreshTokenVo;
import com.inmemory.auth.domain.service.AuthCreateTokenService;
import com.inmemory.auth.domain.service.AuthRefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthTokenCommandService {

    private final AuthCreateTokenService authCreateTokenService;
    private final AuthRefreshTokenService authRefreshTokenService;

    /**
     * 인증에 필요한 토큰을 생성하고 반환한다.
     *
     * @param authCreateTokenCommand 토큰 생성 커맨드
     * @return 토큰 생성 결과
     */
    public AuthCreateTokenVo createToken(AuthCreateTokenCommand authCreateTokenCommand) {
        return authCreateTokenService.createTokenAndSaveRefreshToken(authCreateTokenCommand.getUserNo());
    }

    public AuthRefreshTokenVo refreshToken(AuthRefreshTokenCommand authRefreshTokenCommand) {

    }
}
