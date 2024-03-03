//package com.inmemory.gateway.routes.auth.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
//    public CustomFilter() {
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return ((exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//            ServerHttpResponse response = exchange.getResponse();
//
//            log.info("A.B.C");
//
//            return chain.filter(exchange);
//        });
//    }
//
//    public static class Config {
//        //  properties...
//    }
//}
