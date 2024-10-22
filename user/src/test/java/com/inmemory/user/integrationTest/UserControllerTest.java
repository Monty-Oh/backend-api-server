package com.inmemory.user.integrationTest;

import com.inmemory.user.interfaces.rest.dto.UserLoginReqDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public class UserControllerTest extends WireMockServerTest {

    @Test
    @DisplayName("로그인 요청을 했고 성공 응답을 받는다.")
    void login_success() {
        //  given
        UserLoginReqDto userLoginReqDto = UserLoginReqDto.builder()
                .loginId("testLoginId")
                .password("testPassword")
                .build();

        HttpEntity<UserLoginReqDto> httpEntity = new HttpEntity<>(userLoginReqDto);
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity("/user/login", httpEntity, String.class);

        System.out.println("responseEntity = " + responseEntity);

    }
}
