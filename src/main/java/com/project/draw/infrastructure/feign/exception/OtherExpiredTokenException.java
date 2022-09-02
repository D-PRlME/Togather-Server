package com.project.draw.infrastructure.feign.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class OtherExpiredTokenException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new OtherExpiredTokenException();

    private OtherExpiredTokenException() {
        super(ErrorCode.OTHER_EXPIRED_TOKEN);
    }

}
