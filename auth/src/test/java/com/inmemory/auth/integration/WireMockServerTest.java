package com.inmemory.auth.integration;

import com.inmemory.auth.domain.model.entity.Role;
import com.inmemory.auth.domain.model.entity.UserRole;
import com.inmemory.auth.domain.model.entity.UserRoleId;
import com.inmemory.auth.domain.repository.RoleRepository;
import com.inmemory.auth.domain.repository.UserRoleRepository;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import redis.embedded.RedisServer;

import java.io.IOException;

/**
 * IntegrationTest 를 위한 공통 WireMockServer 세팅 클래스
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(stubs = "classpath:/stubs/**/*.json")
@ActiveProfiles("test")
public class WireMockServerTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @BeforeAll
    static void redisSetup() throws IOException {
        RedisServer redisServer = new RedisServer(6379);
        redisServer.start();
    }

    /**
     * Role 에 관한 데이터 insert
     *
     * @param name        역할 이름
     * @param description 역할 설명
     * @return 저장 결과
     */
    protected Role insertRoleData(String name, String description) {
        Role role = Role.builder()
                .name(name)
                .description(description)
                .build();
        return roleRepository.save(role);
    }

    /**
     * @param userNo    회원 번호
     * @param roleId    RoleId
     */
    protected void insertUserRoleData(String userNo, int roleId) {
        UserRoleId userRoleId = UserRoleId.builder()
                .userNo(userNo)
                .roleId(roleId)
                .build();
        UserRole userRole = UserRole.builder()
                .userRoleId(userRoleId)
                .build();
        userRoleRepository.save(userRole);
    }

}
