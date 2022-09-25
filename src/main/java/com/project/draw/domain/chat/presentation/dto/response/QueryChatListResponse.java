package com.project.draw.domain.chat.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryChatListResponse {

    private Integer page;

    private List<ChatResponse> chatList;

}