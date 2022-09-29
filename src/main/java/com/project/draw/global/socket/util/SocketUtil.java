package com.project.draw.global.socket.util;

import com.corundumstudio.socketio.SocketIOClient;
import com.project.draw.domain.chat.exception.RoomNotFoundException;
import com.project.draw.domain.post.exception.InvalidUserException;
import com.project.draw.global.socket.security.ClientProperty;

public class SocketUtil {

    public static Long getUserId(SocketIOClient socketIOClient){

        if(!socketIOClient.has(ClientProperty.USER_KEY)) {
            throw InvalidUserException.EXCEPTION;
        }

        return socketIOClient.get(ClientProperty.USER_KEY);
    }

    public static Long getRoomId(SocketIOClient socketIOClient) {

        if(!socketIOClient.has(ClientProperty.ROOM_KEY)) {
            throw RoomNotFoundException.EXCEPTION;
        }

        return Long.valueOf(socketIOClient.get(ClientProperty.ROOM_KEY));
    }
}