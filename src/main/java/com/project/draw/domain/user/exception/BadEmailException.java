package com.project.draw.domain.user.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class BadEmailException extends BusinessException {
    public static final BusinessException EXCEPTION = new BadEmailException();
    private BadEmailException(){
        super(ErrorCode.BAD_EMAIL);
    }
}