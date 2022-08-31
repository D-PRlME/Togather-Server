package com.project.draw.global.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class ImageSaveException extends BusinessException {
    public static final BusinessException EXCEPTION = new ImageSaveException();
    private ImageSaveException(){
        super(ErrorCode.IMAGE_SAVE_FAIL);
    }
}