package com.inmemory.user.infrastructure.feign;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;

class AuthFeignClientTest extends WireMockTest{

    @Autowired
    private WireMockServer mockServer;

    @Autowired
    private AuthFeignClient authFeignClient;


}