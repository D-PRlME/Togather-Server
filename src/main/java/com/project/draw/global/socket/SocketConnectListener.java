package com.project.draw.global.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.global.security.jwt.JwtTokenProvider;
import com.project.draw.global.socket.facade.SocketRoomFacade;
import com.project.draw.global.socket.security.ClientProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SocketConnectListener {

    private final JwtTokenProvider jwtTokenProvider;
    private final SocketRoomFacade socketRoomFacade;
    private final UserFacade userFacade;

    @OnConnect
    public void onConnect(SocketIOClient socketIOClient) {

        String token = jwtTokenProvider.resolveToken(socketIOClient);
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        String email = authentication.getName();

        User user = userFacade.getUserByEmail(email);

        socketIOClient.set(ClientProperty.USER_KEY, user.getId());

        socketRoomFacade.joinAllRoom(socketIOClient, user);

    }

}