package com.inemory.user.domain.repository;

import com.inemory.user.infrastructure.dto.AuthCreateTokenRspDto;
import org.springframework.http.ResponseEntity;

public interface AuthRepository {

    ResponseEntity<AuthCreateTokenRspDto> createAccessTokenAndRefreshToken(String userNo);
}
