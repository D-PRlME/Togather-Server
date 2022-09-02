package com.project.draw.infrastructure.feign.exception;


import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class OtherBadRequestException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new OtherBadRequestException();

    private OtherBadRequestException() {
        super(ErrorCode.OTHER_BAD_REQUEST);
    }
}
