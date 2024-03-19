package com.inmemory.user.domain.service;

import com.inmemory.user.common.exception.ApplicationException;
import com.inmemory.user.domain.model.aggregate.User;
import com.inmemory.user.domain.model.vo.AuthCreateTokenVo;
import com.inmemory.user.domain.repository.AuthRepository;
import com.inmemory.user.domain.repository.UserRepository;
import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import com.inmemory.user.infrastructure.feign.mapper.AuthCreateTokenVoMapper;
import com.inmemory.user.common.constants.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthCreateTokenService {

    private final UserRepository userRepository;
    private final AuthRepository authRepository;

    private final AuthCreateTokenVoMapper authCreateTokenVoMapper;

    /**
     * 회원 번호를 조회한 후
     * AccessToken, RefreshToken 생성 요청을 한다.
     * 생성 결과를 반환한다.
     *
     * @param loginId 로그인 아이디
     * @return 토큰 생성 결과
     */
    public AuthCreateTokenVo getUserNoAndCreateToken(String loginId) {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new ApplicationException(ErrorCode.NOT_FOUND_USER_INFO));

        ResponseEntity<AuthCreateTokenRspDto> authCreateTokenRspDtoResponseEntity = authRepository.createAccessTokenAndRefreshToken(user.getUserNo());
        if (Objects.isNull(authCreateTokenRspDtoResponseEntity.getBody())) {
            throw new ApplicationException(ErrorCode.EXTERNAL_SERVER_ERROR);
        }
        return authCreateTokenVoMapper.mapToVo(authCreateTokenRspDtoResponseEntity.getBody());
    }
}
