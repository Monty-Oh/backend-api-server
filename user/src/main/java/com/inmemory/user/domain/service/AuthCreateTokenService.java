package com.inmemory.user.domain.service;

import com.inmemory.user.common.constants.ErrorCode;
import com.inmemory.user.common.exception.ApplicationException;
import com.inmemory.user.domain.model.aggregate.User;
import com.inmemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.user.domain.repository.AuthRepository;
import com.inmemory.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthCreateTokenService {

    private final UserRepository userRepository;
    private final AuthRepository authRepository;

    /**
     * 회원 번호를 조회한 후
     * AccessToken, RefreshToken 생성 요청을 한다.
     * 생성 결과를 반환한다.
     *
     * @param loginId 로그인 아이디
     * @return 토큰 생성 결과
     */
    public AuthCreateTokenVo getUserNoAndCreateToken(String loginId) {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new ApplicationException(ErrorCode.NOT_FOUND_USER_INFO));

        return authRepository.createAccessTokenAndRefreshToken(user.getUserNo());
    }
}
