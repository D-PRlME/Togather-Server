package com.project.draw.domain.chat.presentation;


import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.project.draw.domain.chat.presentation.dto.request.JoinSocketRoomRequest;
import com.project.draw.domain.chat.presentation.dto.request.SendChatRequest;
import com.project.draw.domain.chat.service.JoinSocketRoomService;
import com.project.draw.domain.chat.service.SendChatService;
import com.project.draw.global.socket.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
public class ChatSocketController {

    private final SocketIOServer socketIOServer;
    private final SendChatService sendChatService;
    private final JoinSocketRoomService joinSocketRoomService;

    @OnEvent(SocketProperty.CHAT)
    public void sendChat(SocketIOClient socketIOClient, @RequestBody @Valid SendChatRequest request){
        sendChatService.execute(socketIOServer, socketIOClient, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @OnEvent(SocketProperty.JOIN)
    public void enterRoom(SocketIOClient socketIOClient, @RequestBody @Valid JoinSocketRoomRequest request){
        joinSocketRoomService.execute(socketIOClient, request);
    }

}