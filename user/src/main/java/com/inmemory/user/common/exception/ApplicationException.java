package com.inmemory.user.common.exception;

import com.inmemory.user.common.constants.ErrorCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Getter
public class ApplicationException extends RuntimeException{
    private final String errorCode;

    private final String message;

    private final HttpStatus httpStatus;

    /**
     * 사전 정의되어 있는 에러 코드를 사용하여 필드값 지정
     *
     * @param errorCode 에러 코드
     */
    public ApplicationException(ErrorCode errorCode) {
        this.errorCode = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
        errorLogging(this.errorCode, this.message);
    }

    /**
     * 에러 로깅 메소드
     *
     * @param errorCode 에러 코드
     * @param message   에러 메시지
     */
    private void errorLogging(String errorCode, String message) {
        log.error("[" + errorCode + "]: " + message, this);
    }
}
