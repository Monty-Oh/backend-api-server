package com.inmemory.gateway.route;

import com.inmemory.gateway.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.inmemory.gateway.constants.AuthApiUrl.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class AuthRouteLocator {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * 인증 관련 요청 라우터
     *
     * @param builder RouteLocatorBuilder
     * @return RouteLocator
     */
    @Bean
    public RouteLocator authRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        r -> r.path(REQUEST_LOGIN_URI)
                                .uri(MAPPING_REQUEST_LOGIN_URI)
                )
                .route(
                        r -> r.path(REQUEST_ALL_URI)
                                .filters(
                                        f -> f.filter(jwtAuthenticationFilter.apply(new JwtAuthenticationFilter.Config()))
                                )
                                .uri(MAPPING_REQUEST_ALL_URI)
                )
                .build()
                ;
    }
}
