package com.inemory.user.infrastructure.feign;

import com.inemory.user.domain.repository.AuthRepository;
import com.inemory.user.infrastructure.dto.AuthCreateTokenRspDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import static com.inemory.user.infrastructure.constants.AuthUrl.AUTH_CREATE_TOKEN;

@FeignClient(name = "AuthFeignClient", url = "${feign.api.auth-url}")
public interface AuthFeignClient extends AuthRepository {

    @PostMapping(AUTH_CREATE_TOKEN)
    ResponseEntity<AuthCreateTokenRspDto> createAccessTokenAndRefreshToken(String userNo);

}
