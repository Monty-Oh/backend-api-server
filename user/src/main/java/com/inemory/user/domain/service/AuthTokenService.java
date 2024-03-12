package com.inemory.user.domain.service;

import com.inemory.user.common.constants.ErrorCode;
import com.inemory.user.common.exception.ApplicationException;
import com.inemory.user.domain.model.aggregate.User;
import com.inemory.user.domain.repository.AuthRepository;
import com.inemory.user.domain.repository.UserRepository;
import com.inemory.user.infrastructure.dto.AuthCreateTokenRspDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthTokenService {

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
    public ResponseEntity<AuthCreateTokenRspDto> getUserNoAndCreateToken(String loginId) {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new ApplicationException(ErrorCode.NOT_FOUND_USER_INFO));

        return authRepository.createAccessTokenAndRefreshToken(user.getUserNo());
    }
}
