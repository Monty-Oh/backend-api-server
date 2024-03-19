package com.inmemory.user.common.configuration;

import com.inmemory.user.common.constants.StaticValues;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Collection;
import java.util.Objects;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        Collection<String> headerErrorCode = response.headers().get(StaticValues.HEADER_ERROR_CODE);
        String errorCode =
                Objects.isNull(headerErrorCode) ?
    }
}
