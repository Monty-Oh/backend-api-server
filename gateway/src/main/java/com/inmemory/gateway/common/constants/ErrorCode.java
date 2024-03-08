package com.inmemory.gateway.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //  공통 에러
    TEST_CODE("0001", "테스트 메시지", HttpStatus.INTERNAL_SERVER_ERROR),
    INTERNAL_SERVER_ERROR("0000", "서버 에러가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),

    //  인증 에러
    TOKEN_EXPIRED_ERROR("0101", "토큰 정보가 만료되었습니다.", HttpStatus.UNAUTHORIZED),
    TOKEN_STATUS_ERROR("0102", "토큰 정보가 잘못되었습니다.", HttpStatus.BAD_REQUEST),
    TOKEN_NOT_FOUND_ERROR("0103", "토큰 정보가 존재하지 않습니다.", HttpStatus.UNAUTHORIZED),
    ;

    private final String code;

    private final String message;

    private final HttpStatus httpStatus;
}
