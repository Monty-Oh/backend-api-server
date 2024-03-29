package com.inmemory.auth.domain.service;

import com.inmemory.auth.common.utils.JwtUtils;
import com.inmemory.auth.domain.repository.AuthRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthCreateTokenServiceTest {

    @InjectMocks
    private AuthCreateTokenService authCreateTokenService;

    @Mock
    private AuthRepository authRepository;
    @Mock
    private JwtUtils jwtUtils;


}