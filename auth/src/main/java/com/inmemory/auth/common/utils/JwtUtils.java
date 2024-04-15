package com.inmemory.auth.common.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils {

    private final SecretKey jwtSecretKey;

    @Value("${service.jwt.valid-time.access}")
    private static long accessTokenValidTime;

    @Value("${service.jwt.valid-time.refresh}")
    private static long refreshTokenValidTime;

    public JwtUtils(@Value("${service.jwt.secret-key}") String secretKey) {
        this.jwtSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    /**
     * 액세스 토큰 생성 후 반환
     *
     * @param userNo 회원 번호
     * @return 액세스 토큰
     */
    public String createAccessToken(String userNo) {
        return createToken(userNo, accessTokenValidTime);
    }

    /**
     * 리프레시 토큰 생성 후 반환
     *
     * @param userNo 회원 번호
     * @return 리프레시 토큰
     */
    public String createRefreshToken(String userNo) {
        return createToken(userNo, refreshTokenValidTime);
    }

    /**
     * 토큰 생성 후 반환한다.
     *
     * @param userNo    claim 으로 저장할 회원 번호
     * @param validTime 만료 시간
     * @return 생성된 토큰
     */
    private String createToken(String userNo, long validTime) {
        return Jwts.builder()
                .claims().add("userNo", userNo)
                .and()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + validTime))
                .signWith(jwtSecretKey)
                .compact()
                ;
    }

}
