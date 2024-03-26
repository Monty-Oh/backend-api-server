package com.inmemory.user.infrastructure.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    protected void setupSuccessResponse(String requestHttpMethod, String requestUrl, Object responseBody) throws JsonProcessingException {
        WireMock.stubFor(
                WireMock.request(requestHttpMethod, WireMock.urlMatching(requestUrl))
                        .willReturn(WireMock.aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBody(mapper.writeValueAsString(responseBody)))
        );
    }
}
