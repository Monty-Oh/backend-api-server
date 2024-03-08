package com.inmemory.gateway.exception;

import com.inmemory.gateway.constants.ErrorCode;
import lombok.Getter;

/**
 * 토큰 검증 Exception
 */
@Getter
public class InvalidTokenException extends ApplicationException{
    public InvalidTokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
