package com.project.draw.domain.user.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class BadAuthCodeException extends BusinessException {
    public static final BusinessException EXCEPTION = new BadAuthCodeException();
    private BadAuthCodeException(){
        super(ErrorCode.BAD_AUTH_CODE);
    }
}