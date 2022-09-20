package com.project.draw.domain.post.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class PostNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new PostNotFoundException();
    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}