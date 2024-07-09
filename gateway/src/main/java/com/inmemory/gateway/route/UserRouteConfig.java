package com.inmemory.gateway.route;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.inmemory.gateway.common.constant.ApiUrl.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class UserRouteConfig {

    /**
     * user 서비스 대응 라우터
     */
    @Bean
    public RouteLocator userRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        USER_LOGIN_ROUTE_ID,
                        route -> route
                                .path("/user/**")
                                .uri(MAPPING_USER_URL)
                )
                .build()
                ;
    }
}
