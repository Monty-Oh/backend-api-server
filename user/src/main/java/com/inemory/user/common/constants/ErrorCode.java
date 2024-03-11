package com.inemory.user.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //  공통 에러
    TEST_CODE("0001", "테스트 메시지", HttpStatus.INTERNAL_SERVER_ERROR),
    INTERNAL_SERVER_ERROR("0000", "서버 에러가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),

    NOT_FOUND_USER_INFO("0301", "사용자 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD("0302", "비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED)
    ;

    private final String code;

    private final String message;

    private final HttpStatus httpStatus;
}
