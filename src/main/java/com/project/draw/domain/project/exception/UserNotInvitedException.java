package com.project.draw.domain.project.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class UserNotInvitedException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotInvitedException();
    private UserNotInvitedException(){
        super(ErrorCode.USER_NOT_INVITED);
    }
}