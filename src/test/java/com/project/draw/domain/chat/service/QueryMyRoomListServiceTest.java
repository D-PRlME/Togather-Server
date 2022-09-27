package com.project.draw.domain.chat.service;

import com.project.draw.domain.chat.domain.RoomUser;
import com.project.draw.domain.chat.domain.repository.RoomUserRepository;
import com.project.draw.domain.chat.presentation.dto.response.QueryRoomListResponse;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class QueryMyRoomListServiceTest {

    @Mock
    private UserFacade userFacade;

    @Mock
    private RoomUserRepository roomUserRepository;

    @InjectMocks
    private QueryMyRoomListService service;

    @Test
    public void 방_리스트_조회_성공() {
        //given
        User user = User.builder().build();
        List<RoomUser> arrayList = new ArrayList<>();

        given(userFacade.getCurrentUser()).willReturn(user);
        given(roomUserRepository.findByUser(user)).willReturn(arrayList);

        //when
        QueryRoomListResponse response = service.execute();

        //then
        assertThat(arrayList).isEqualTo(response.getRoomList());

        then(roomUserRepository).should(times(1)).findByUser(user);
    }
}