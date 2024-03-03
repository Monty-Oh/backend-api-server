package com.inmemory.gateway.routes.auth.route;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AuthRouteLocatorConfig {

    @Bean
    public RouteLocator authRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        r -> r.path("/auth/**")
                                .and()
                                .uri("http://localhost:8081")
                )
                .build()
        ;
    }
}
