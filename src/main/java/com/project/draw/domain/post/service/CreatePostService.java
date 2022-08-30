package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.repository.PostRepository;
import com.project.draw.domain.post.presentation.dto.request.CreatePostRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreatePostService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreatePostRequest request) {
        User user = userFacade.getCurrentUser();



        postRepository.save(
                Post.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .tags(request.getTags())
                        .link(request.getLink())
                        .user(user)
                        .build());
    }
}
