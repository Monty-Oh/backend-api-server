package com.inmemory.auth.common.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {

    private final SecretKey jwtSecretKey;

    @Value("${service.jwt.valid-time.access}")
    private long accessTokenValidTime;

    @Value("${service.jwt.valid-time.refresh}")
    private long refreshTokenValidTime;

    public JwtUtils(@Value("${service.jwt.secret-key}") String secretKey) {
        this.jwtSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    /**
     * 액세스 토큰 생성 후 반환
     *
     * @param userNo 회원 번호
     * @return 액세스 토큰
     */
    public String createAccessToken(String userNo, List<String> userRoleList) {
        return Jwts.builder()
                .claims()
                .add("userNo", userNo)
                .add("userRoles", userRoleList)
                .and()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + accessTokenValidTime))
                .signWith(jwtSecretKey)
                .compact()
                ;
    }

    /**
     * 리프레시 토큰 생성 후 반환
     *
     * @param userNo 회원 번호
     * @return 리프레시 토큰
     */
    public String createRefreshToken(String userNo) {
        return Jwts.builder()
                .claims()
                .add("userNo", userNo)
                .and()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + refreshTokenValidTime))
                .signWith(jwtSecretKey)
                .compact()
                ;
    }
}
