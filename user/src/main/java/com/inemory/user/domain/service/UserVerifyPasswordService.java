package com.inemory.user.domain.service;

import com.inemory.user.common.constants.ErrorCode;
import com.inemory.user.common.exception.ApplicationException;
import com.inemory.user.common.utils.EncryptUtil;
import com.inemory.user.domain.model.aggregate.User;
import com.inemory.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.inemory.user.common.constants.ErrorCode.INVALID_PASSWORD;

@Service
@RequiredArgsConstructor
public class UserVerifyPasswordService {

    private final UserRepository userRepository;
    private final EncryptUtil encryptUtil;

    /**
     * userId 와 password 를 비교해서 password 가 일치하는지 확인한다.
     *
     * @param loginId  로그인 Id
     * @param password 비밀번호
     */
    public void verifyPassword(String loginId, String password) {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new ApplicationException(ErrorCode.NOT_FOUND_USER_INFO));

        if (!encryptUtil.match(password, user.getPassword())) {
            throw new ApplicationException(INVALID_PASSWORD);
        }
    }
}
