package com.project.draw.domain.chat.presentation.dto.response;

import com.project.draw.domain.chat.domain.Chat;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class ChatResponse {

    private Long roomId;
    private UserResponse user;
    private LocalDateTime createdAt;
    private String message;

    public static ChatResponse of(Chat chat) {

        User user = chat.getUser();

        return ChatResponse
                .builder()
                .roomId(chat.getRoom().getId())
                .user(UserResponse.of(user))
                .message(chat.getMessage())
                .createdAt(chat.getCreatedAt().toLocalDateTime())
                .build();
    }
}