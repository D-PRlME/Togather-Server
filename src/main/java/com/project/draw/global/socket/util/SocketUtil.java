package com.project.draw.global.socket.util;

import com.corundumstudio.socketio.SocketIOClient;
import com.project.draw.domain.chat.exception.RoomNotFoundException;
import com.project.draw.global.socket.security.ClientProperty;

public class SocketUtil {

    public static String getEmail(SocketIOClient socketIOClient){
        return socketIOClient.get(ClientProperty.USER_KEY);
    }

    public static Long getRoomId(SocketIOClient socketIOClient) {

        if(socketIOClient.get(ClientProperty.ROOM_KEY) == null) {
            throw RoomNotFoundException.EXCEPTION;
        }
        
        return Long.valueOf(socketIOClient.get(ClientProperty.ROOM_KEY));
    }
}