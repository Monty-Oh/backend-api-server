package com.inmemory.gateway.filter;

import com.inmemory.gateway.common.exception.InvalidTokenException;
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

import static com.inmemory.gateway.common.constants.ErrorCode.TOKEN_NOT_FOUND_ERROR;
import static com.inmemory.gateway.common.constants.StaticValue.HEADER_ACCESS_TOKEN;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtAuthenticationGlobalFilter implements GlobalFilter {

    private final JwtUtils jwtUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
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
        String accessToken = httpHeaders.getFirst(HEADER_ACCESS_TOKEN);
        if (Objects.isNull(accessToken)) {
            throw new InvalidTokenException(TOKEN_NOT_FOUND_ERROR);
        }
        return accessToken;
    }
}
