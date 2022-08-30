package com.project.draw.domain.post.presentation.dto.response;

import com.project.draw.domain.post.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@AllArgsConstructor
public class PostListResponse {
    private final List<PostResponse> postList;

    @Getter
    @Builder
    public static class PostResponse {
        private final String title;
        private final String user_name;
        private final List<Tag> tags;
        private final LocalDateTime createdAt;
    }
}
