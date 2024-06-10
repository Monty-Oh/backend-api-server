package com.inmemory.gateway.common.exception.handler;

import com.inmemory.gateway.common.exception.ApplicationException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import static com.inmemory.gateway.common.constants.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.inmemory.gateway.common.constants.StaticValue.HEADER_RESPONSE_CODE;
import static com.inmemory.gateway.common.constants.StaticValue.HEADER_RESPONSE_MESSAGE;

@Order(-2)
@Slf4j
@Component
public class GlobalExceptionHandler implements WebExceptionHandler {

    @Override
    @NonNull
    public Mono<Void> handle(ServerWebExchange exchange, @NonNull Throwable ex) {
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        HttpHeaders serverHttpResponseHeaders = serverHttpResponse.getHeaders();

        if (ex instanceof ApplicationException applicationException) {
            serverHttpResponseHeaders.add(HEADER_RESPONSE_CODE, applicationException.getErrorCode());
            serverHttpResponseHeaders.add(HEADER_RESPONSE_MESSAGE, applicationException.getMessage());
            serverHttpResponse.setStatusCode(applicationException.getHttpStatus());
        } else {
            serverHttpResponseHeaders.add(HEADER_RESPONSE_CODE, INTERNAL_SERVER_ERROR.getCode());
            serverHttpResponseHeaders.add(HEADER_RESPONSE_MESSAGE, INTERNAL_SERVER_ERROR.getMessage());
            serverHttpResponse.setStatusCode(INTERNAL_SERVER_ERROR.getHttpStatus());
        }

        return serverHttpResponse.setComplete();
    }
}
