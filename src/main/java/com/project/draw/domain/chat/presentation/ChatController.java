package com.project.draw.domain.chat.presentation;

import com.project.draw.domain.chat.presentation.dto.request.CreatePrivateChatRoomRequest;
import com.project.draw.domain.chat.presentation.dto.response.CreateRoomResponse;
import com.project.draw.domain.chat.presentation.dto.response.QueryChatListResponse;
import com.project.draw.domain.chat.presentation.dto.response.QueryRoomListResponse;
import com.project.draw.domain.chat.service.CreatePrivateChatRoomService;
import com.project.draw.domain.chat.service.QueryChatListService;
import com.project.draw.domain.chat.service.QueryMyRoomListService;
import lombok.RequiredArgsConstructor;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.Format;
import java.time.LocalDateTime;

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
                                               @RequestParam("time") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime localDateTime) {
        return queryChatListService.execute(roomId, localDateTime);
    }

    @GetMapping("/room")
    public QueryRoomListResponse queryMyRoomList() {
        return queryMyRoomListService.execute();
    }

}