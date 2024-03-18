package com.inemory.user.domain.service;

import com.inemory.user.common.utils.EncryptUtil;
import com.inemory.user.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserVerifyPasswordServiceTest {

    @InjectMocks
    private UserVerifyPasswordService userVerifyPasswordService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private EncryptUtil encryptUtil;

    @Test
    @DisplayName("userId와 password를 비교해 일치하는지 확인한다.")
    void verifyPassword_success() {
        //
    }
}