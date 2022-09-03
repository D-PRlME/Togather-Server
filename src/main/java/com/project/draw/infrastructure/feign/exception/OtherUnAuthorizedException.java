package com.project.draw.infrastructure.feign.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class OtherUnAuthorizedException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new OtherUnAuthorizedException();

    private OtherUnAuthorizedException() {

        super(ErrorCode.OTHER_UNAUTHORIZED);
    }

}