package com.inmemory.user.domain.repository;

import com.inmemory.user.domain.model.vo.AuthCreateTokenVo;

public interface AuthRepository {

    /**
     * Auth 애플리케이션에게 토큰 생성 요청을 한다.
     *
     * @param userNo 로그인 요청 대상
     * @return 토큰 생성 결과
     */
    AuthCreateTokenVo createAccessTokenAndRefreshToken(String userNo);
}
