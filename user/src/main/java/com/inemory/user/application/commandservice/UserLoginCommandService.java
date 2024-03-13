package com.inemory.user.application.commandservice;

import com.inemory.user.domain.model.command.UserLoginCommand;
import com.inemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inemory.user.domain.service.AuthTokenService;
import com.inemory.user.domain.service.UserVerifyPasswordService;
import com.inemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginCommandService {

    private final UserVerifyPasswordService userVerifyPasswordService;
    private final AuthTokenService authTokenService;

    /**
     * 로그인 애플리케이션 서비스
     * 비밀번호를 검증하고, 토큰 발급 요청을 한다.
     *
     * @param userLoginCommand 로그인 요청 Command
     * @return 발급된 토큰 값
     */
    public AuthCreateTokenVo login(UserLoginCommand userLoginCommand) {
        userVerifyPasswordService.verifyPassword(userLoginCommand.getLoginId(), userLoginCommand.getPassword());
        return authTokenService.getUserNoAndCreateToken(userLoginCommand.getLoginId());
    }
}
