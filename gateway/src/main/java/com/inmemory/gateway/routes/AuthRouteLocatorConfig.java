package com.inmemory.gateway.routes;

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
        builder.routes()
                .route(
                        route -> route.path("/auth/**")
                                .and()
                                .uri("http://localhost:8081")
                )
        ;

        return builder.routes().build();
    }
}
