package com.project.draw.global.socket;

import com.project.draw.domain.chat.facade.RoomFacade;
import com.project.draw.domain.chat.facade.RoomUserFacade;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.global.security.jwt.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SocketConnectListenerTest {

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private UserFacade userFacade;

    @Mock
    private RoomFacade roomFacade;

    @Mock
    private RoomUserFacade roomUserFacade;

    @InjectMocks
    private SocketConnectListener socketConnectListener;

    @Test
    public void 소켓_연결_성공() {
        //given

        //when

        //then

    }

}