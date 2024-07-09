package com.inmemory.auth.domain.service;

import com.inmemory.auth.common.utils.JwtUtils;
import com.inmemory.auth.domain.model.entity.Role;
import com.inmemory.auth.domain.model.entity.UserRole;
import com.inmemory.auth.domain.model.entity.UserRoleId;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.domain.repository.AuthRepository;
import com.inmemory.auth.domain.repository.RoleRepository;
import com.inmemory.auth.domain.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Slf4j
@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {""})
class AuthCreateTokenServiceTest {

    @InjectMocks
    private AuthCreateTokenService authCreateTokenService;

    @Mock
    private UserRoleRepository userRoleRepository;
    @Mock
    private AuthRepository authRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private JwtUtils jwtUtils;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(authCreateTokenService, "refreshKeyTtl", 10);
    }

    @Test
    @DisplayName("액세스 토큰 발급에 성공한다.")
    void createTokenAndSaveRefreshToken_success() {
        //  given
        List<UserRole> userRoleList = List.of(
                UserRole.builder()
                        .userRoleId(
                                UserRoleId.builder()
                                        .roleId(0)
                                        .userNo("0")
                                        .build()
                        )
                        .build()
        );
        given(userRoleRepository.findByUserRoleIdUserNo(anyString())).willReturn(userRoleList);
        List<Role> roleList = List.of(
                Role.builder()
                        .id(0)
                        .name("ROLE_TEST")
                        .build()
        );
        given(roleRepository.findByIdIn(anyList())).willReturn(roleList);

        String accessToken = "TEST_ACCESS_TOKEN";
        String refreshToken = "TEST_REFRESH_TOKEN";
        given(jwtUtils.createAccessToken(anyString(), anyList())).willReturn(accessToken);
        given(jwtUtils.createRefreshToken(anyString())).willReturn(refreshToken);

        //  when
        AuthCreateTokenVo actual = authCreateTokenService.createTokenAndSaveRefreshToken("testUserNo");

        //  then
        assertAll(
                () -> assertThat(actual.getAccessToken()).isEqualTo(accessToken),
                () -> assertThat(actual.getRefreshToken()).isEqualTo(refreshToken),
                () -> verify(authRepository, times(1)).findByUserNo(anyString())
        );
    }
}