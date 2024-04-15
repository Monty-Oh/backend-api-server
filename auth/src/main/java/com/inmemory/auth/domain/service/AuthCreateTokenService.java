package com.inmemory.auth.domain.service;

import com.inmemory.auth.common.utils.JwtUtils;
import com.inmemory.auth.domain.model.aggregate.Auth;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.domain.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthCreateTokenService {

    private final AuthRepository authRepository;
    private final JwtUtils jwtUtils;

    /**
     * 인증에 필요한 엑세스 토큰과 리프레시 토큰을 발급하고, 반환한다.
     * 리프레시 토큰은 userNo 에 맞게 저장한다.
     *
     * @param userNo 회원 번호
     * @return 액세스 토큰과 리프레시 토큰
     */
    public AuthCreateTokenVo createTokenAndSaveRefreshToken(String userNo) {
        AuthCreateTokenVo authCreateTokenVo = createAccessTokenAndRefreshToken(userNo);
        saveRefreshToken(userNo, authCreateTokenVo.getRefreshToken());
        return authCreateTokenVo;
    }

    private AuthCreateTokenVo createAccessTokenAndRefreshToken(String userNo) {
        return AuthCreateTokenVo.builder()
                .accessToken(jwtUtils.createAccessToken(userNo))
                .refreshToken(jwtUtils.createRefreshToken(userNo))
                .build();
    }

    private void saveRefreshToken(String userNo, String refreshToken) {
        Auth auth = authRepository.findByUserNo(userNo).orElse(new Auth(userNo));
        auth.changeRefreshToken(refreshToken);
        authRepository.save(auth);
    }
}
