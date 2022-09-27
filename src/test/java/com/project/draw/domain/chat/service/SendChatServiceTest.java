package com.project.draw.domain.chat.service;

import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;
import com.corundumstudio.socketio.protocol.Packet;
import com.project.draw.domain.chat.domain.Chat;
import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.repository.ChatRepository;
import com.project.draw.domain.chat.facade.RoomFacade;
import com.project.draw.domain.chat.presentation.dto.request.SendChatRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.SocketAddress;
import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class SendChatServiceTest {

    @Mock
    private ChatRepository chatRepository;

    @Mock
    private UserFacade userFacade;

    @Mock
    private RoomFacade roomFacade;

    @InjectMocks
    private SendChatService service;

    @Test
    public void 채팅_전송_성공() {
        //given
        SocketIOServer socketIOServer = new SocketIOServer(new Configuration());
        SendChatRequest request = new SendChatRequest();

        User user = User.builder().build();
        Room room = Room.builder().build();
        setField(room, "id", 1L);

        Chat chat = Chat.builder().room(room).user(user).build();

        given(roomFacade.getCurrentRoom(any())).willReturn(room);
        given(chatRepository.save(any())).willReturn(chat);

        //when
        service.execute(socketIOServer, getSocketIOClient(), request);

        //then
        then(chatRepository).should(times(1)).save(any());
    }

    private SocketIOClient getSocketIOClient() {
        return new SocketIOClient() {
            @Override
            public HandshakeData getHandshakeData() {
                return null;
            }

            @Override
            public Transport getTransport() {
                return null;
            }

            @Override
            public void sendEvent(String name, AckCallback<?> ackCallback, Object... data) {

            }

            @Override
            public void send(Packet packet, AckCallback<?> ackCallback) {

            }

            @Override
            public SocketIONamespace getNamespace() {
                return null;
            }

            @Override
            public UUID getSessionId() {
                return null;
            }

            @Override
            public SocketAddress getRemoteAddress() {
                return null;
            }

            @Override
            public boolean isChannelOpen() {
                return false;
            }

            @Override
            public void joinRoom(String room) {

            }

            @Override
            public void leaveRoom(String room) {

            }

            @Override
            public Set<String> getAllRooms() {
                return null;
            }

            @Override
            public void send(Packet packet) {

            }

            @Override
            public void disconnect() {

            }

            @Override
            public void sendEvent(String name, Object... data) {

            }

            @Override
            public void set(String key, Object val) {

            }

            @Override
            public <T> T get(String key) {
                return null;
            }

            @Override
            public boolean has(String key) {
                return false;
            }

            @Override
            public void del(String key) {

            }
        };
    }
}