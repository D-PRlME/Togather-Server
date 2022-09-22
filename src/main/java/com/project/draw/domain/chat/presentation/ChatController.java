package com.project.draw.domain.chat.presentation;

import com.project.draw.domain.chat.presentation.dto.response.QueryChatListResponse;
import com.project.draw.domain.chat.presentation.dto.response.QueryRoomListResponse;
import com.project.draw.domain.chat.service.QueryChatListService;
import com.project.draw.domain.chat.service.QueryMyRoomListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/chats")
@RestController
public class ChatController {

    private final QueryChatListService queryChatLIstService;
    private final QueryMyRoomListService queryMyRoomListService;

    @GetMapping("/{room-id}")
    public QueryChatListResponse queryChatList(@PathVariable("room-id") Long roomId, Pageable pageable) {
        return queryChatLIstService.execute(roomId, pageable);
    }

    @GetMapping("/")
    public QueryRoomListResponse queryMyRoomList() {
        return queryMyRoomListService.execute();
    }

}