package com.project.draw.global.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;


public class ImageValueNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new ImageValueNotFoundException();
    private ImageValueNotFoundException() {
        super(ErrorCode.IMAGE_VALUE_NOT_FOUND);
    }
}