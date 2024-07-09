package com.inmemory.user.common.configuration;

import com.inmemory.user.common.constants.ErrorCode;
import com.inmemory.user.common.constants.StaticValues;
import com.inmemory.user.common.exception.ApplicationException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Objects;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        Collection<String> headerErrorCode = response.headers().get(StaticValues.HEADER_ERROR_CODE);
        ErrorCode errorCode = ErrorCode.EXTERNAL_SERVER_ERROR;
        if (!Objects.isNull(headerErrorCode) && !headerErrorCode.isEmpty()) {
            errorCode = ErrorCode.findByCode(headerErrorCode.iterator().next());
        }
        return new ApplicationException(errorCode);
    }
}
