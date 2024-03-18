package com.inemory.user.domain.service;

import com.inemory.user.domain.model.aggregate.User;
import com.inemory.user.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserVerifyPasswordServiceTest {

    @InjectMocks
    private UserVerifyPasswordService userVerifyPasswordService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("userId와 password를 비교해 일치하는지 확인한다.")
    void verifyPassword_success() {
        //  given
        User user = User.builder()
                .loginId("testLoginId")
                .password("$2a$10$ZZby9MXeQ7LJLtnOTSbM4O44e7ze5a3O1R9Sv00to4PwDgFtlQVBG")
                .build();
        given(userRepository.findByLoginId(anyString())).willReturn(Optional.of(user));

        //  when,   then
        assertDoesNotThrow(() -> userVerifyPasswordService.verifyPassword("testLoginId", "testPassword"));
    }
}