package com.project.draw.domain.post.presentation.dto.response;

import com.project.draw.domain.post.domain.Tag;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostInfoResponse {
    private final String title;
    private final String userName;
    private final LocalDateTime createdAt;
    private final List<Tag> tags;
    private final String content;
    private final String link;
}
