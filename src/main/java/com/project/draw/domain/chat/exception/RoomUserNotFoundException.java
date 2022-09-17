package com.project.draw.domain.chat.exception;

import com.project.draw.global.error.exception.BusinessException;
import com.project.draw.global.error.exception.ErrorCode;

public class RoomUserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new RoomUserNotFoundException();
    private RoomUserNotFoundException(){
        super(ErrorCode.ROOM_USER_NOT_FOUND);
    }
}