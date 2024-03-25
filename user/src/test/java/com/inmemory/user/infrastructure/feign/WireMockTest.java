package com.inmemory.user.infrastructure.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock
public class WireMockTest {
    @Autowired
    protected ObjectMapper mapper;

    protected void setupPostSuccessResponse(WireMockServer wireMockServer, Object responseBody) throws JsonProcessingException {
        wireMockServer.stubFor(
                WireMock.post(WireMock.anyUrl())
                        .willReturn(WireMock.aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBody(mapper.writeValueAsString(responseBody)))
        );
    }
}
