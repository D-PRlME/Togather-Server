package com.project.draw.domain.chat.service;

import com.project.draw.domain.chat.domain.enums.RoomType;
import com.project.draw.domain.chat.domain.repository.RoomRepository;
import com.project.draw.domain.chat.presentation.dto.response.QueryRoomListResponse;
import com.project.draw.domain.chat.presentation.dto.response.RoomResponse;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryMyRoomListService {

    private final RoomRepository roomRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryRoomListResponse execute(RoomType roomType) {

        User user = userFacade.getCurrentUser();

        return new QueryRoomListResponse(
                roomRepository.findByRoomTypeAndRoomUsers_user(roomType, user)
                        .stream()
                        .map(room -> RoomResponse.of(user, room))
                        .collect(Collectors.toList())
        );
    }

}