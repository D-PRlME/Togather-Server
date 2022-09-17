package com.project.draw.domain.user.presentation.dto.response;

import com.project.draw.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private final Long userId;
    private final String userName;
    private final String profileImageUrl;

    public static UserResponse of(User user) {

        return UserResponse
                .builder()
                .userId(user.getId())
                .userName(user.getName())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
    }
}