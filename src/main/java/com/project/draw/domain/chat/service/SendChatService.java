package com.project.draw.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.project.draw.domain.chat.domain.Chat;
import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.repository.ChatRepository;
import com.project.draw.domain.chat.facade.RoomFacade;
import com.project.draw.domain.chat.facade.RoomUserFacade;
import com.project.draw.domain.chat.presentation.dto.request.SendChatRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.global.socket.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SendChatService {

    private final ChatRepository chatRepository;
    private final UserFacade userFacade;
    private final RoomFacade roomFacade;
    private final RoomUserFacade roomUserFacade;

    @Transactional
    public void execute(SocketIOServer socketIOServer, SocketIOClient socketIOClient, SendChatRequest request) {

        User user = userFacade.getCurrentUser(socketIOClient);
        Room room = roomFacade.getRoomById(request.getRoomId());

        roomUserFacade.checkRoomUserExist(room, user);

        Chat chat = chatRepository.save(Chat
                .builder()
                .message(request.getMessage())
                .room(room)
                .user(user)
                .build());

        socketIOServer.getRoomOperations(room.getId().toString())
                .sendEvent(SocketProperty.CHAT, chat);
    }
}