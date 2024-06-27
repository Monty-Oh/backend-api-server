package com.inmemory.auth.common.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JwtUtilsTest {

    @InjectMocks
    private JwtUtils jwtUtils;

    @BeforeEach

    @Test
    void createAccessToken() {
        JwtUtils jwtUtils = new JwtUtils("TEST KEY");
        ReflectionTestUtils.setField(jwtUtils, "accessTokenValidTime", 10L);
        ReflectionTestUtils.setField(jwtUtils, "jwtSecretKey", "TEST_KEY");
    }

    @Test
    void createRefreshToken() {
    }
}