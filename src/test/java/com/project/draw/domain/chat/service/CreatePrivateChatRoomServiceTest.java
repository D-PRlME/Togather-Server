package com.project.draw.domain.chat.service;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.repository.PrivateRoomRepository;
import com.project.draw.domain.chat.domain.repository.RoomRepository;
import com.project.draw.domain.chat.facade.RoomFacade;
import com.project.draw.domain.chat.presentation.dto.request.CreatePrivateChatRoomRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class CreatePrivateChatRoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private PrivateRoomRepository privateRoomRepository;

    @Mock
    private RoomFacade roomFacade;

    @Mock
    private UserFacade userFacade;

    @InjectMocks
    private CreatePrivateChatRoomService service;

    @Test
    public void 개인채팅방_생성_성공() {

        //given
        CreatePrivateChatRoomRequest request = new CreatePrivateChatRoomRequest();

        User userA = User.builder().build();
        setField(userA, "id", 1L);
        User userB = User.builder().build();
        setField(userB, "id", 2L);

        Room room = Room.builder().build();

        given(userFacade.getCurrentUser()).willReturn(userA);
        given(userFacade.getUserById(any())).willReturn(userB);
        given(roomRepository.save(any())).willReturn(room);

        //when
        service.execute(request);

        //then
        then(roomRepository).should(times(1)).save(any());
        then(privateRoomRepository).should(times(1)).save(any());
    }
}