package com.project.draw.domain.chat.service;

import com.project.draw.domain.chat.domain.RoomUser;
import com.project.draw.domain.chat.domain.repository.ChatRepository;
import com.project.draw.domain.chat.facade.RoomUserFacade;
import com.project.draw.domain.chat.presentation.dto.response.ChatResponse;
import com.project.draw.domain.chat.presentation.dto.response.QueryChatListResponse;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryChatListService {

    private final ChatRepository chatRepository;
    private final RoomUserFacade roomUserFacade;
    private final UserFacade userFacade;

    @Transactional
    public QueryChatListResponse execute(Long roomId, Pageable pageable) {

        User user = userFacade.getCurrentUser();
        RoomUser roomUser = roomUserFacade.getById(roomId, user.getId());

        roomUser.updateLastReadTime();

        return new QueryChatListResponse(
                pageable.getPageNumber(),
                chatRepository.findByRoomId(roomId, pageable)
                        .stream()
                        .map(ChatResponse::of)
                        .collect(Collectors.toList())
        );
    }
}