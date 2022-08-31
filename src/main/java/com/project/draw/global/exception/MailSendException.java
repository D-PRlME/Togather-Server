package com.project.draw.global.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class MailSendException extends BusinessException {
    public static final BusinessException EXCEPTION = new MailSendException();
    private MailSendException(){
        super(ErrorCode.MAIL_SEND_FAIL);
    }

}