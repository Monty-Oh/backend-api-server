package com.inmemory.auth.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(MockitoExtension.class)
class JwtUtilsTest {

    private JwtUtils jwtUtils;

    private SecretKey jwtSecretKey;

    @BeforeEach
    void setUp() {
        String secretKey = "2cb6363001584512e547b1e327a0404dd48ba9e2452b277c0d0bb4aec3024aff5a82fe17c50e5ed573223b7139cd476252d6082673c33fe1677be106d5223252";
        jwtUtils = new JwtUtils(secretKey);
        ReflectionTestUtils.setField(jwtUtils, "accessTokenValidTime", 30);
        ReflectionTestUtils.setField(jwtUtils, "refreshTokenValidTime", 43200);

        jwtSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    @Test
    void createAccessToken() {
        //  given
        String userNo = "testUserNo";
        List<String> userRoleList = new ArrayList<>() {{
            add("ROLE_TEST");
        }};

        //  when
        String actual = jwtUtils.createAccessToken(userNo, userRoleList);

        //  then
        Jws<Claims> actualClaims = Jwts.parser()
                .verifyWith(jwtSecretKey)
                .build()
                .parseSignedClaims(actual);

        String actualUserNo = (String) actualClaims.getPayload().get("userNo");
        List<String> actualUserRoleList = ((List<?>) actualClaims.getPayload().get("userRoles"))
                .stream()
                .map(value -> (String) value)
                .toList();

        assertAll(
                () -> assertThat(actualUserNo).isEqualTo(userNo),
                () -> assertThat(userRoleList.size()).isEqualTo(actualUserRoleList.size()),
                () -> assertThat(userRoleList.get(0)).isEqualTo(actualUserRoleList.get(0))
        );
    }

    @Test
    void createRefreshToken() {
    }
}