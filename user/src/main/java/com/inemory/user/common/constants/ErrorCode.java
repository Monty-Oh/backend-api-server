package com.inemory.user.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //  공통 에러
    INTERNAL_SERVER_ERROR("0000", "서버 에러가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    EXTERNAL_SERVER_ERROR("0001", "외부 서비스 호출 도중 에러가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),

    //  인증,인가 에러
    NOT_FOUND_TOKEN_INFO("0101", "토큰 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    NOT_FOUND_USER_INFO("0301", "사용자 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD("0302", "비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED)
    ;

    private final String code;

    private final String message;

    private final HttpStatus httpStatus;
}
