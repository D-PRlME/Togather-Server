package com.project.draw.domain.chat.service;

import com.project.draw.domain.chat.domain.enums.RoomType;
import com.project.draw.domain.chat.domain.repository.RoomRepository;
import com.project.draw.domain.chat.presentation.dto.response.QueryChatListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyRoomListService {

    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public QueryChatListResponse execute(RoomType roomType) {
        return null;
    }

}