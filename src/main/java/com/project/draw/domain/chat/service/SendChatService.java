package com.project.draw.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.project.draw.domain.chat.domain.Chat;
import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.RoomUser;
import com.project.draw.domain.chat.domain.repository.ChatRepository;
import com.project.draw.domain.chat.facade.RoomFacade;
import com.project.draw.domain.chat.facade.RoomUserFacade;
import com.project.draw.domain.chat.presentation.dto.request.SendChatRequest;
import com.project.draw.domain.chat.presentation.dto.response.ChatResponse;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.global.socket.SocketProperty;
import com.project.draw.global.socket.util.SocketUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SendChatService {

    private final ChatRepository chatRepository;
    private final UserFacade userFacade;
    private final RoomUserFacade roomUserFacade;
    private final RoomFacade roomFacade;

    @Transactional
    public void execute(SocketIOServer socketIOServer, SocketIOClient socketIOClient, SendChatRequest request) {

        User user = userFacade.getCurrentUser(socketIOClient);
        Room room = roomFacade.getCurrentRoom(socketIOClient);

        RoomUser roomUser = roomUserFacade.getById(room.getId(), user.getId());

        Chat chat = chatRepository.save(Chat
                .builder()
                .message(request.getMessage())
                .room(room)
                .user(user)
                .build());

        room.updateLastMessage(chat);
        roomUser.updateLastReadTime();

        socketIOServer
                .getRoomOperations(room.getId().toString())
                .getClients()
                .forEach(client -> {
                    client.sendEvent(SocketProperty.CHAT, ChatResponse.of(chat));
                    RoomUser clientRoomUser = roomUserFacade
                            .getById(room.getId(), SocketUtil.getUserId(client));
                    clientRoomUser.updateLastReadTime();
                });

    }
}