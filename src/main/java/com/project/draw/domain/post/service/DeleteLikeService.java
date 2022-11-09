package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.Like;
import com.project.draw.domain.post.domain.LikeUserId;
import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.repository.LikeRepository;
import com.project.draw.domain.post.facade.PostFacade;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

        Optional<Like> optionalLike = likeRepository.findById(LikeUserId
                .builder()
                .user(user.getId())
                .post(post.getId())
                .build()
        );

        optionalLike.ifPresent(likeRepository::delete);
    }
}