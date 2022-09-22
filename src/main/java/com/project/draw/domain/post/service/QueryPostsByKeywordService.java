package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.repository.PostRepository;
import com.project.draw.domain.post.presentation.dto.response.PostListResponse;
import com.project.draw.domain.post.presentation.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryPostsByKeywordService {
    private final PostRepository postRepository;

    @Transactional
    public PostListResponse execute(String keyword, Sort sort) {
        List<PostResponse> postList = postRepository.findByTitleContains(keyword, sort)
                .stream()
                .map(PostResponse::of)
                .collect(Collectors.toList());

        return new PostListResponse(postList);
    }
}