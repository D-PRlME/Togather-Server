package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.LikeUserId;
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
public class DeleteLikeService {
    private final LikeRepository likeRepository;
    private final UserFacade userFacade;
    private final PostFacade postFacade;

    @Transactional
    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Post post = postFacade.getPostById(id);

        likeRepository.deleteById(LikeUserId.builder()
                .user(user.getId())
                .post(post.getId())
                .build());
    }
}
