package com.project.draw.domain.post.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class PostListResponse {
    private final List<PostResponse> postList;
}