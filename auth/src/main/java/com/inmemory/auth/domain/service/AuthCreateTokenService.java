package com.inmemory.auth.domain.service;

import com.inmemory.auth.common.utils.JwtUtils;
import com.inmemory.auth.domain.model.aggregate.Auth;
import com.inmemory.auth.domain.model.entity.Role;
import com.inmemory.auth.domain.model.entity.UserRole;
import com.inmemory.auth.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.auth.domain.repository.AuthRepository;
import com.inmemory.auth.domain.repository.RoleRepository;
import com.inmemory.auth.domain.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthCreateTokenService {

    private final AuthRepository authRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final JwtUtils jwtUtils;

    /**
     * 인증에 필요한 엑세스 토큰과 리프레시 토큰을 발급하고, 반환한다.
     * 리프레시 토큰은 userNo 에 맞게 저장한다.
     *
     * @param userNo 회원 번호
     * @return 액세스 토큰과 리프레시 토큰
     */
    public AuthCreateTokenVo createTokenAndSaveRefreshToken(String userNo) {
        List<String> userRoleList = getUserRoleList(userNo);
        AuthCreateTokenVo authCreateTokenVo = createAccessTokenAndRefreshToken(userNo, userRoleList);
        saveRefreshToken(userNo, authCreateTokenVo.getRefreshToken());
        return authCreateTokenVo;
    }

    private AuthCreateTokenVo createAccessTokenAndRefreshToken(String userNo, List<String> userRoleList) {
        return AuthCreateTokenVo.builder()
                .accessToken(jwtUtils.createAccessToken(userNo, userRoleList))
                .refreshToken(jwtUtils.createRefreshToken(userNo))
                .build();
    }

    private void saveRefreshToken(String userNo, String refreshToken) {
        Auth auth = authRepository.findByUserNo(userNo).orElse(new Auth(userNo));
        auth.changeRefreshToken(refreshToken);
        authRepository.save(auth);
    }

    private List<String> getUserRoleList(String userNo) {
        List<UserRole> userRoleList = userRoleRepository.findByUserRoleIdUserNo(userNo);
        List<Integer> targetRoleIdList = userRoleList.stream()
                .map(userRole -> userRole.getUserRoleId().getRoleId())
                .toList();
        List<Role> roleList = roleRepository.findByIdIn(targetRoleIdList);
        return roleList.stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }
}
