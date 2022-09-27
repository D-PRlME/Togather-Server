package com.project.draw.domain.chat.service;


import com.corundumstudio.socketio.SocketIOClient;
import com.project.draw.domain.chat.presentation.dto.request.JoinSocketRoomRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.global.socket.facade.SocketRoomFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JoinSocketRoomService {

    private final UserFacade userFacade;
    private final SocketRoomFacade socketRoomFacade;

    public void execute(SocketIOClient socketIOClient, JoinSocketRoomRequest request) {

        User user = userFacade.getCurrentUser(socketIOClient);

        if(request.getIsJoinRoom()) {
            String roomId = request.getRoomId().toString();
            socketRoomFacade.joinOneRoom(socketIOClient, user, roomId);
        } else {
            socketRoomFacade.joinAllRoom(socketIOClient, user);
        }
    }
}