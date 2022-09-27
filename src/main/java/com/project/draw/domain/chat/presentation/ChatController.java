package com.project.draw.domain.chat.presentation;

import com.project.draw.domain.chat.presentation.dto.request.CreatePrivateChatRoomRequest;
import com.project.draw.domain.chat.presentation.dto.response.CreateRoomResponse;
import com.project.draw.domain.chat.presentation.dto.response.QueryChatListResponse;
import com.project.draw.domain.chat.presentation.dto.response.QueryRoomListResponse;
import com.project.draw.domain.chat.service.CreatePrivateChatRoomService;
import com.project.draw.domain.chat.service.QueryChatListService;
import com.project.draw.domain.chat.service.QueryMyRoomListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/chats")
@RestController
public class ChatController {

    private final QueryChatListService queryChatListService;
    private final QueryMyRoomListService queryMyRoomListService;
    private final CreatePrivateChatRoomService createPrivateChatRoomService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/room")
    public CreateRoomResponse createPrivateChatRoom(@RequestBody @Valid CreatePrivateChatRoomRequest request) {
        return createPrivateChatRoomService.execute(request);
    }

    @GetMapping("/{room-id}")
    public QueryChatListResponse queryChatList(@PathVariable("room-id") Long roomId,
                                               @PageableDefault(size=50, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
        return queryChatListService.execute(roomId, pageable);
    }

    @GetMapping("")
    public QueryRoomListResponse queryMyRoomList() {
        return queryMyRoomListService.execute();
    }

}