package com.project.draw.domain.chat.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.draw.domain.chat.domain.Chat;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.presentation.dto.response.UserResponse;
import com.project.draw.global.util.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class ChatResponse {

    @JsonProperty("room_id")
    private Long roomId;

    @JsonProperty("is_mine")
    private Boolean isMine;

    @JsonProperty("sent_at")
    private String sentAt;

    @JsonProperty("sent_date")
    private LocalDate sentDate;

    @JsonProperty("user")
    private UserResponse user;

    @JsonProperty("message")
    private String message;

    public static ChatResponse of(Chat chat, Boolean isMine) {

        User user = chat.getUser();

        return ChatResponse
                .builder()
                .roomId(chat.getRoom().getId())
                .isMine(isMine)
                .user(UserResponse.of(user))
                .message(chat.getMessage())
                .sentAt(DateUtil.meridiemFormat(chat.getCreatedAt()))
                .sentDate(chat.getCreatedAt().toLocalDate())
                .build();
    }
}