package com.inemory.user.infrastructure.feign;

import com.inemory.user.domain.repository.AuthRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "AuthFeignClient", url = "${feign.api.auth-url}")
public interface AuthFeignClient extends AuthRepository {

    @PostMapping
    Object createAccessTokenAndRefreshToken();
}
