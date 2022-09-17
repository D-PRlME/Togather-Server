package com.project.draw.global.socket.util;

import com.corundumstudio.socketio.SocketIOClient;
import com.project.draw.global.socket.security.ClientProperty;

public class SocketUtil {

    public static String getEmail(SocketIOClient socketIOClient){
        return socketIOClient.get(ClientProperty.USER_KEY);
    }

}