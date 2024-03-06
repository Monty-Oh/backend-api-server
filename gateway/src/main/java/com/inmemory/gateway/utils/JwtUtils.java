package com.inmemory.gateway.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils {

    private final SecretKey jwtSecretKey;

    public JwtUtils(@Value("${service.jwt.secret-key}") String secretKey) {
        this.jwtSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    /**
     * 전달받은 토큰을 가지고 검증한다.
     *
     * @param accessToken
     */
    public void validateToken(String accessToken) {
        try {
            Date expirationDate = Jwts.parser()
                    .verifyWith(jwtSecretKey)
                    .build()
                    .parseSignedClaims(accessToken)
                    .getPayload()
                    .getExpiration();

            LocalDateTime now = LocalDateTime.now();
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
