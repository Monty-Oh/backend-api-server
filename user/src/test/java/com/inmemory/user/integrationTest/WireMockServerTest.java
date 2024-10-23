package com.inmemory.user.integrationTest;

import com.inmemory.user.common.utils.EncryptUtil;
import com.inmemory.user.domain.model.aggregate.User;
import com.inmemory.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

/**
 * IntegrationTest 를 위한 공통 WireMockServer 세팅 클래스
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 8080, stubs = "classpath:/stubs/**/*.json")
@ActiveProfiles("unit-test")
public class WireMockServerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected TestRestTemplate restTemplate;

    /**
     * DB에 UserData 세팅
     *
     * @param userNo    회원 번호
     * @param loginId   로그인 ID
     * @param password  비밀번호
     */
    protected void insertUserData(String userNo, String loginId, String password) {
        String encryptedPassword = EncryptUtil.encode(password);
        User user = User.builder()
                .userNo(userNo)
                .loginId(loginId)
                .password(encryptedPassword)
                .build();
        userRepository.save(user);
    }
}
