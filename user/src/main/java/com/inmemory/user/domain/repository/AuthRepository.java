package com.inmemory.user.domain.repository;

import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import org.springframework.http.ResponseEntity;

public interface AuthRepository {

    /**
     * Auth 애플리케이션에게 토큰 생성 요청을 한다.
     *
     * @param userNo 로그인 요청이 들어온 userNo
     * @return 토큰 생성 결과
     */
    ResponseEntity<AuthCreateTokenRspDto> createAccessTokenAndRefreshToken(String userNo);
}
