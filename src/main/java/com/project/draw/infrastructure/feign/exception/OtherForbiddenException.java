package com.project.draw.infrastructure.feign.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class OtherForbiddenException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new OtherForbiddenException();

    private OtherForbiddenException() {
        super(ErrorCode.OTHER_FORBIDDEN);
    }

}
