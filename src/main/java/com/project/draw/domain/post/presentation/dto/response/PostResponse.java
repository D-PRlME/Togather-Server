package com.project.draw.domain.post.presentation.dto.response;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.Tag;
import com.project.draw.domain.user.presentation.dto.response.UserResponse;
import com.project.draw.global.util.date.DateUtil;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostResponse {

    private final Long postId;
    private final String title;
    private final UserResponse user;
    private final List<Tag> tags;
    private final String createdAt;
    private final Boolean isComplete;

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .tags(post.getTags())
                .user(UserResponse.of(post.getUser()))
                .createdAt(DateUtil.createdAtToString(post.getCreatedAt().toLocalDateTime()))
                .isComplete(post.isComplete())
                .build();
    }
}