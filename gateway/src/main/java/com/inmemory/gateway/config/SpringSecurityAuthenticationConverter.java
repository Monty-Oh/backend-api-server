package com.inmemory.gateway.config;

import com.inmemory.gateway.common.constant.StaticValues;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class SpringSecurityAuthenticationConverter implements ServerAuthenticationConverter {

    /**
     * 스프링 시큐리티에 필요한 인증 데이터를 가져온다.
     * HttpHeaders.AUTHORIZATION 에 저장되어 있다.
     * 헤더에 존재하지 않거나, 비어있으면 그냥 패스한다.
     */
    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        String accessToken = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(accessToken) && accessToken.startsWith(StaticValues.ACCESS_TOKEN_START_WITH_STRING)) {
            accessToken = accessToken.replace(StaticValues.ACCESS_TOKEN_START_WITH_STRING, StaticValues.EMPTY_STRING);
            return Mono.just(new UsernamePasswordAuthenticationToken(accessToken, accessToken));
        }
        return Mono.empty();
    }
}
