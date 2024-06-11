package com.inmemory.gateway.filter;

import com.inmemory.gateway.common.constants.ErrorCode;
import com.inmemory.gateway.common.exception.InvalidTokenException;
import com.inmemory.gateway.common.property.WhiteListProperties;
import com.inmemory.gateway.common.utils.JwtUtils;
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

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtAuthenticationGlobalFilter implements GlobalFilter {

    private final WhiteListProperties whiteListProperties;

    private final JwtUtils jwtUtils;

    /**
     * 액세스 토큰 검증 필터
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if (whiteListProperties.isWhiteList(request.getURI().getPath())) {
            return chain.filter(exchange);
        }

        String accessToken = getAccessToken(request.getHeaders());
        jwtUtils.validateToken(accessToken);
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
}
