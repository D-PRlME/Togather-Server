package com.project.draw.domain.post.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class InvalidUserException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidUserException();
    private InvalidUserException() {
        super(ErrorCode.INVALID_USER);
    }
}