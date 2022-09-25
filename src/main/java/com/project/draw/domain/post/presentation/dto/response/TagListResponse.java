package com.project.draw.domain.post.presentation.dto.response;

import com.project.draw.domain.post.domain.enums.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TagListResponse {
    private final List<Tag> tags;
}