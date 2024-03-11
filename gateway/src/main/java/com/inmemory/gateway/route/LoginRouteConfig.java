package com.inmemory.gateway.route;

import com.inmemory.gateway.filter.JwtAuthenticationFilter;
import com.inmemory.gateway.filter.LogFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.inmemory.gateway.constants.ApiUrl.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LoginRouteConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final LogFilter logFilter;

    /**
     * 로그인 요청 API 대응 라우터
     *
     * @param builder RouteLocatorBuilder
     * @return RouteLocator
     */
    @Bean
    public RouteLocator authRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        r -> r.path(REQUEST_LOGIN_URI)
                                .filters(
                                        f -> f.filter(logFilter.apply(new LogFilter.Config()))
                                                .rewritePath(REQUEST_LOGIN_URI, MAPPING_BASE_USER_URL + MAPPING_LOGIN_URI)
                                )
                                .uri(MAPPING_USER_URL)
                )
                .build()
                ;
    }
}
