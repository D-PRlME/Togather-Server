package com.project.draw.domain.project.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class ProjectNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new ProjectNotFoundException();
    private ProjectNotFoundException(){
        super(ErrorCode.PROJECT_NOT_FOUND);
    }
}