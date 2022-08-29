package com.project.draw.domain.user.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class UnverifiedEmailException extends BusinessException {
    public static final BusinessException EXCEPTION = new UnverifiedEmailException();
    private UnverifiedEmailException() {
        super(ErrorCode.UNVERIFIED_EMAIL);
    }
}