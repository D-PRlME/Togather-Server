package com.project.draw.domain.chat.service;

import com.project.draw.domain.chat.domain.repository.RoomUserRepository;
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

    private final RoomUserRepository roomUserRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryRoomListResponse execute() {

        User user = userFacade.getCurrentUser();

        return new QueryRoomListResponse(
                roomUserRepository.findByUser(user)
                        .stream()
                        .map(RoomResponse::of)
                        .collect(Collectors.toList())
        );
    }

}