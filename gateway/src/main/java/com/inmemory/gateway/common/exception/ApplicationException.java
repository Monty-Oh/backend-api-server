package com.inmemory.gateway.common.exception;

import com.inmemory.gateway.common.constants.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Application 에서 사용하는 공통 Exception
 */
@Getter
public class ApplicationException extends RuntimeException {

    private final String errorCode;

    private final String message;

    private final HttpStatus httpStatus;

    public ApplicationException(ErrorCode errorCode) {
        this.errorCode = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }

    public ApplicationException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode.getCode();
        this.message = message;
        this.httpStatus = errorCode.getHttpStatus();
    }
}
