package com.project.draw.domain.post.presentation.dto.response;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.Tag;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostResponse {

    private final Long postId;
    private final String title;
    private final String userName;
    private final String userProfileImage;
    private final List<Tag> tags;
    private final LocalDateTime createdAt;

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .tags(post.getTags())
                .userName(post.getUser().getName())
                .userProfileImage(post.getUser().getProfileImageUrl())
                .createdAt(post.getCreatedAt())
                .build();
    }
}