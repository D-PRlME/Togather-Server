package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.facade.PostFacade;
import com.project.draw.domain.post.presentation.dto.response.PostInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryPostInfoService {
    private final PostFacade postFacade;

    public PostInfoResponse execute(Long id) {

        Post post = postFacade.getPostById(id);

        return PostInfoResponse.of(post);
    }
}