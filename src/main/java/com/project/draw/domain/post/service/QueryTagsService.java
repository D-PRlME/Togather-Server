package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.enums.Tag;
import com.project.draw.domain.post.presentation.dto.response.TagListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryTagsService {

    public TagListResponse execute(){
    return new TagListResponse(
        Arrays
                .stream(Tag.class.getEnumConstants())
                .collect(Collectors.toList())
            );
    }
}