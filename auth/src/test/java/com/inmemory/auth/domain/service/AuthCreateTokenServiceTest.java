package com.inmemory.auth.domain.service;

import com.inmemory.auth.common.utils.JwtUtils;
import com.inmemory.auth.domain.model.entity.Role;
import com.inmemory.auth.domain.model.entity.UserRole;
import com.inmemory.auth.domain.model.entity.UserRoleId;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.domain.repository.AuthRepository;
import com.inmemory.auth.domain.repository.RoleRepository;
import com.inmemory.auth.domain.repository.UserRoleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {""})
class AuthCreateTokenServiceTest {

    @InjectMocks
    private AuthCreateTokenService authCreateTokenService;

    @Mock
    private AuthRepository authRepository;
    @Mock
    private UserRoleRepository userRoleRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private JwtUtils jwtUtils;

    @Test
    @DisplayName("액세스 토큰 발급에 성공한다.")
    void createTokenAndSaveRefreshToken_success() {
        //  given
        given(jwtUtils.createAccessToken(anyString(), anyList())).willReturn("accessToken");
        given(jwtUtils.createRefreshToken(anyString())).willReturn("refreshToken");
        List<UserRole> userRoleList = List.of(
                UserRole.builder()
                        .userRoleId(
                                UserRoleId.builder()
                                        .roleId(2)
                                        .userNo("0")
                                        .build()
                        )
                        .build()
        );
        given(userRoleRepository.findByUserRoleIdUserNo(anyString())).willReturn(userRoleList);
        List<Role> roleList = List.of(
                Role.builder()
                        .id(2)
                        .name("ROLE_MASTER")
                        .description("ROLE_MASTER")
                        .build()
        );
        given(roleRepository.findByIdIn(anyList())).willReturn(roleList);
        given(authRepository.findByUserNo(anyString())).willReturn(Optional.empty());

        //  when
        AuthCreateTokenVo actual = authCreateTokenService.createTokenAndSaveRefreshToken("testUserNo");

        //  then
        assertAll(
                () -> assertThat(actual.getAccessToken()).isEqualTo("accessToken"),
                () -> assertThat(actual.getRefreshToken()).isEqualTo("refreshToken")
        );
    }
}