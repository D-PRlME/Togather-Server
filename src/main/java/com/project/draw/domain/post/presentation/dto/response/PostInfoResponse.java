package com.project.draw.domain.post.presentation.dto.response;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.Tag;
import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Builder
public class PostInfoResponse {
    private final String title;
    private final String userName;
    private final String createdAt;
    private final List<Tag> tags;
    private final String content;
    private final String link;
    private final boolean isComplete;

    public static PostInfoResponse of(Post post) {
        return PostInfoResponse
                .builder()
                .title(post.getTitle())
                .userName(post.getUser().getName())
                .content(post.getContent())
                .link(post.getLink())
                .tags(post.getTags())
                .createdAt(post.getCreatedAt()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .isComplete(post.isComplete())
                .build();
    }
}