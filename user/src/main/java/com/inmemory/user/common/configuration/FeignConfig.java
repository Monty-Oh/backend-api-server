package com.inmemory.user.common.configuration;

import feign.ResponseInterceptor;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Bean
    public ResponseInterceptor responseInterceptor() {
    }

}
