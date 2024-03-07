package com.inmemory.gateway.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Slf4j
@Component
public class JwtUtils {

    private final SecretKey jwtSecretKey;

    public JwtUtils(@Value("${service.jwt.secret-key}") String secretKey) {
        this.jwtSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    /**
     * 전달 받은 토큰을 가지고 검증한다.
     *
     * @param accessToken   로그인 토큰
     */
    public void validateToken(String accessToken) {
        try {
            Jwts.parser()
                    .verifyWith(jwtSecretKey)
                    .build()
                    .parseSignedClaims(accessToken)
                    .getPayload()
                    .getExpiration();
        } catch (ExpiredJwtException exception) {
            log.info("인증서 만료 메시지");
            throw exception;
        } catch (SignatureException | MalformedJwtException exception) {
            log.info("인증서 형식 오류 메시지");
            throw exception;
        } catch (Exception exception) {
            log.info("알 수 없는 에러");
            throw exception;
        }
    }
}
