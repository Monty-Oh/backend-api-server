package com.inmemory.auth.domain.service;

import com.inmemory.auth.common.utils.JwtUtils;
import com.inmemory.auth.domain.model.vo.AuthRefreshTokenVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthRefreshTokenService {

    private final JwtUtils jwtUtils;

    public AuthRefreshTokenVo refreshToken(String refreshToken) {
        Jws<Claims> claimsJws = jwtUtils.parsingToken(refreshToken);
    }
}
