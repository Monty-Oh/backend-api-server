package com.inmemory.gateway.config;

import com.inmemory.gateway.common.constant.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {
    private final SpringSecurityAuthenticationConverter springSecurityAuthenticationConverter;
    private final SpringSecurityAuthenticationManager springSecurityAuthenticationManager;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(springSecurityAuthenticationManager);
        authenticationWebFilter.setServerAuthenticationConverter(springSecurityAuthenticationConverter);

        //  인증 매니저 설정
        serverHttpSecurity
                .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
        ;

        //  TODO: 추후 상세히 작업할 것. 지금은 false
        //  cors, csrf 설정
        serverHttpSecurity
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors(ServerHttpSecurity.CorsSpec::disable)
        ;

        //  URI : ROLE 인가 매칭 설정
        serverHttpSecurity
                .authorizeExchange(
                        exchange -> exchange
                                .pathMatchers(
                                        "/user/monitor/healthcheck",
                                        "/swagger-ui",
                                        "/user/v1/users/login",
                                        "/auth/v1/token"
                                ).permitAll()
//                                .pathMatchers(

//                                ).hasRole(UserRole.ROLE_MASTER.getName())
//                                .anyExchange().hasRole(UserRole.ROLE_GUEST.getName())
                                .anyExchange().authenticated()
                )
        ;

        return serverHttpSecurity.build();
    }
}
