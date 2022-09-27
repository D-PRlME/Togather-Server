package com.project.draw.domain.chat.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class RoomAlreadyExistException extends BusinessException {
    public static final BusinessException EXCEPTION = new RoomAlreadyExistException();
    private RoomAlreadyExistException(){
        super(ErrorCode.ROOM_ALREADY_EXIST);
    }
}