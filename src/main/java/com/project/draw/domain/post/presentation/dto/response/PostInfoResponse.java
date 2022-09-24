package com.project.draw.domain.post.presentation.dto.response;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.Tag;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Builder
public class PostInfoResponse {
    private final String title;
    private final UserResponse user;
    private final Boolean isMine;
    private final String createdAt;
    private final List<Tag> tags;
    private final String content;
    private final String link;
    private final Boolean isComplete;
    private final Integer likeCount;
    private final Boolean isLiked;

    public static PostInfoResponse of(User user, Post post, boolean isLiked) {
        return PostInfoResponse
                .builder()
                .title(post.getTitle())
                .user(UserResponse.of(post.getUser()))
                .isMine(post.getUser() == user)
                .createdAt(post.getCreatedAt()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .tags(post.getTags())
                .content(post.getContent())
                .link(post.getLink())
                .isComplete(post.isComplete())
                .likeCount(post.getLikes().size())
                .isLiked(isLiked)
                .build();
    }
}