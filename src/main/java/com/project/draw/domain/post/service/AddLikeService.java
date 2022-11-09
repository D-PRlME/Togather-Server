package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.Like;
import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.repository.LikeRepository;
import com.project.draw.domain.post.facade.PostFacade;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddLikeService {
    private final UserFacade userFacade;
    private final PostFacade postFacade;
    private final LikeRepository likeRepository;

    @Transactional
    public void execute(Long id) {
        Post post = postFacade.getPostById(id);
        User user = userFacade.getCurrentUser();

        likeRepository.save(Like
                .builder()
                .user(user)
                .post(post)
                .build()
        );
    }
}