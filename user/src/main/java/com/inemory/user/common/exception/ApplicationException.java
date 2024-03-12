package com.inemory.user.common.exception;

import com.inemory.user.common.constants.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
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
     * 메시지 재정의 하기 위한 생성자
     *
     * @param errorCode 에러 코드
     * @param message   재정의 메시지
     */
    public ApplicationException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode.getCode();
        this.message = message;
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