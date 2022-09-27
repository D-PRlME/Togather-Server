package com.project.draw.domain.user.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.draw.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    @JsonProperty("user_id")
    private final Long userId;

    @JsonProperty("user_name")
    private final String userName;

    @JsonProperty("profile_image_url")
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