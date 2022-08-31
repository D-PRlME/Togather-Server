package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.facade.PostFacade;
import com.project.draw.domain.post.presentation.dto.request.UpdatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdatePostService {
    private final PostFacade postFacade;

    public void execute(Long id, UpdatePostRequest request) {

        Post post = postFacade.getPost(id);

        postFacade.checkUser(post);

        post.updatePost(request.getTitle(), request.getContent(), request.getTags(), request.getLink());
    }
}