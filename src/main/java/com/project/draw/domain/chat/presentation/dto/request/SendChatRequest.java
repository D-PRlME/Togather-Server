package com.project.draw.domain.chat.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendChatRequest {

    @JsonProperty("room_id")
    private Long roomId;

    private String message;
}