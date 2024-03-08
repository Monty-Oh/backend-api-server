package com.inmemory.gateway.filter;

import com.inmemory.gateway.exception.InvalidTokenException;
import com.inmemory.gateway.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.inmemory.gateway.constants.ErrorCode.TOKEN_NOT_FOUND_ERROR;
import static com.inmemory.gateway.constants.StaticValue.HEADER_ACCESS_TOKEN;

@Slf4j
@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    private final JwtUtils jwtUtils;

    public static class Config {
        //  properties...
    }

    @Autowired
    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        super(Config.class);
        this.jwtUtils = jwtUtils;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest serverHttpRequest = exchange.getRequest();
            ServerHttpResponse serverHttpResponse = exchange.getResponse();
            String accessToken = getAccessTokenFromHeader(serverHttpRequest);
            jwtUtils.validateToken(accessToken);
            return chain.filter(exchange);
        });
    }

    /**
     * AccessToken 을 request header 에서 추출
     *
     * @param serverHttpRequest 요청 객체
     * @return AccessToken 정보
     */
    private String getAccessTokenFromHeader(ServerHttpRequest serverHttpRequest) {
        List<String> accessTokens = serverHttpRequest.getHeaders().get(HEADER_ACCESS_TOKEN);
        if (Objects.isNull(accessTokens)) {
            throw new InvalidTokenException(TOKEN_NOT_FOUND_ERROR);
        }
        return accessTokens.get(0);
    }
}
