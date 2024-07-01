package com.inmemory.auth.domain.service;

import com.inmemory.auth.common.utils.JwtUtils;
import com.inmemory.auth.domain.repository.RoleRepository;
import com.inmemory.auth.domain.repository.UserRoleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {""})
class AuthCreateTokenServiceTest {

    @InjectMocks
    private AuthCreateTokenService authCreateTokenService;

    @Mock
    private UserRoleRepository userRoleRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private JwtUtils jwtUtils;

    @Test
    @DisplayName("액세스 토큰 발급에 성공한다.")
    void createTokenAndSaveRefreshToken_success() {
    }
}