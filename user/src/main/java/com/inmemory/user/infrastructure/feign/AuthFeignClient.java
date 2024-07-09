package com.inmemory.user.infrastructure.feign;

import com.inmemory.user.common.configuration.FeignConfig;
import com.inmemory.user.infrastructure.feign.constants.AuthUrl;
import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenReqDto;
import com.inmemory.user.infrastructure.feign.dto.AuthCreateTokenRspDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "AuthFeignClient", url = "${feign.api.auth-url}", configuration = FeignConfig.class)
public interface AuthFeignClient {

    /**
     * Auth 애플리케이션에게 토큰 생성 요청을 한다.
     *
     * @param authCreateTokenReqDto 로그인 요청이 들어온 userNo 이 담긴 ReqDto
     * @return 토큰 생성 결과
     */
    @PostMapping(AuthUrl.AUTH_CREATE_TOKEN)
    ResponseEntity<AuthCreateTokenRspDto> createAccessTokenAndRefreshToken(AuthCreateTokenReqDto authCreateTokenReqDto);
}
