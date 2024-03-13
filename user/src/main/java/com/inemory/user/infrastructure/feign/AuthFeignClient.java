package com.inemory.user.infrastructure.feign;

import com.inemory.user.domain.repository.AuthRepository;
import com.inemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import static com.inemory.user.infrastructure.feign.constants.AuthUrl.AUTH_CREATE_TOKEN;

@FeignClient(name = "AuthFeignClient", url = "${feign.api.auth-url}")
public interface AuthFeignClient extends AuthRepository {

    /**
     * Auth 애플리케이션에게 토큰 생성 요청을 한다.
     *
     * @param userNo 로그인 요청이 들어온 userNo
     * @return 토큰 생성 결과
     */
    @PostMapping(AUTH_CREATE_TOKEN)
    ResponseEntity<AuthCreateTokenRspDto> createAccessTokenAndRefreshToken(String userNo);

}
