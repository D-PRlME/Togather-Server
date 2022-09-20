package com.project.draw.domain.post.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class BadTagException extends BusinessException {
    public static final BusinessException EXCEPTION = new BadTagException();

    private BadTagException() {
        super(ErrorCode.BAD_TAG);
    }
}