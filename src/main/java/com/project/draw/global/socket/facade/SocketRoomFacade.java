package com.project.draw.global.socket.facade;

import com.corundumstudio.socketio.SocketIOClient;
import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.RoomUser;
import com.project.draw.domain.chat.facade.RoomFacade;
import com.project.draw.domain.chat.facade.RoomUserFacade;
import com.project.draw.domain.user.domain.User;
import com.project.draw.global.socket.security.ClientProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SocketRoomFacade {

    private final RoomFacade roomFacade;
    private final RoomUserFacade roomUserFacade;

    public void joinAllRoom(SocketIOClient socketIOClient, User user) {

        roomUserFacade.getByUser(user)
                .stream()
                .map(RoomUser::getRoom)
                .forEach(room -> socketIOClient.joinRoom(String.valueOf(room.getId())));

    }

    public void joinOneRoom(SocketIOClient socketIOClient, User user, String roomId) {

        Room room = roomFacade.getRoomById(Long.valueOf(roomId));

        roomUserFacade.checkRoomUserExist(room, user);

        socketIOClient
                .getAllRooms()
                .forEach(socketIOClient::leaveRoom);

        socketIOClient.set(ClientProperty.ROOM_KEY, roomId);
        socketIOClient.joinRoom(roomId);
    }
}