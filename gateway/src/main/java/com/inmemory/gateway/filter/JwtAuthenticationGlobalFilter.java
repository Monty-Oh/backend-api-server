package com.inmemory.gateway.filter;

import com.inmemory.gateway.common.constant.ErrorCode;
import com.inmemory.gateway.common.exception.ApplicationException;
import com.inmemory.gateway.common.exception.InvalidTokenException;
import com.inmemory.gateway.common.property.WhiteListProperties;
import com.inmemory.gateway.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static com.inmemory.gateway.common.constant.ErrorCode.*;

/**
 * Spring Security 로 인증/인가 기능 옮김으로써 미사용
 * TODO: 삭제
 */
@Deprecated
@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtAuthenticationGlobalFilter implements GlobalFilter {

    private final WhiteListProperties whiteListProperties;

    private final JwtUtils jwtUtils;

    /**
     * 액세스 토큰 검증 필터
     * 액세스 토큰 파싱 후 Attributes 에 저장한다.
     *
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        if (whiteListProperties.isWhiteList(request.getURI().getPath())) {
//            return chain.filter(exchange);
//        }
//
//        String accessToken = getAccessToken(request.getHeaders());
//        Jws<Claims> accessTokenClaims = this.parsingAccessTokenToClaims(accessToken);
//
//        exchange.getAttributes().put(HttpHeaders.AUTHORIZATION, accessTokenClaims);
        return chain.filter(exchange);
    }

    /**
     * AccessToken 을 request header 에서 추출
     *
     * @param httpHeaders 요청 객체 Headers
     * @return AccessToken 정보
     */
    private String getAccessToken(HttpHeaders httpHeaders) {
        String accessToken = httpHeaders.getFirst(HttpHeaders.AUTHORIZATION);
        if (Objects.isNull(accessToken)) {
            throw new InvalidTokenException(ErrorCode.TOKEN_NOT_FOUND_ERROR);
        }
        return accessToken;
    }

    /**
     * 액세스 토큰을 Claims 로 파싱한다.
     *
     * @param accessToken 요청으로부터 전달받은 액세스 토큰
     */
    private Jws<Claims> parsingAccessTokenToClaims(String accessToken) {
        try {
            return jwtUtils.parsingToken(accessToken);
        } catch (ExpiredJwtException exception) {
            throw new InvalidTokenException(TOKEN_EXPIRED_ERROR);
        } catch (SignatureException | MalformedJwtException exception) {
            throw new InvalidTokenException(TOKEN_STATUS_ERROR);
        } catch (Exception exception) {
            throw new ApplicationException(INTERNAL_SERVER_ERROR);
        }
    }
}
