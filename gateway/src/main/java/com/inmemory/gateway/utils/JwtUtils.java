package com.inmemory.gateway.utils;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class JwtUtils {

    //  TODO: 시크릿 키는 별도로 보관할 것.
    private static final String JWT_SECRET_KEY = "2cb6363001584512e547b1e327a0404dd48ba9e2452b277c0d0bb4aec3024aff5a82fe17c50e5ed573223b7139cd476252d6082673c33fe1677be106d5223252";

    public String createToken(int id) {
        LocalDateTime now = LocalDateTime.now();
    }
}
