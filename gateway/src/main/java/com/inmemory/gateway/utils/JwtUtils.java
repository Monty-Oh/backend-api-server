package com.inmemory.gateway.utils;

import com.inmemory.gateway.common.exception.ApplicationException;
import com.inmemory.gateway.common.exception.InvalidTokenException;
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

import static com.inmemory.gateway.common.constants.ErrorCode.*;

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
     * @param token 전달 받은 토큰
     */
    public void validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(jwtSecretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getExpiration();
        } catch (ExpiredJwtException exception) {
            throw new InvalidTokenException(TOKEN_EXPIRED_ERROR);
        } catch (SignatureException | MalformedJwtException exception) {
            throw new InvalidTokenException(TOKEN_STATUS_ERROR);
        } catch (Exception exception) {
            throw new ApplicationException(INTERNAL_SERVER_ERROR);
        }
    }
}
