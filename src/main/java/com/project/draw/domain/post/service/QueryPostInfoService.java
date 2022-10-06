package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.LikeUserId;
import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.repository.LikeRepository;
import com.project.draw.domain.post.facade.PostFacade;
import com.project.draw.domain.post.presentation.dto.response.PostInfoResponse;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryPostInfoService {

    private final PostFacade postFacade;
    private final UserFacade userFacade;
    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public PostInfoResponse execute(Long id) {

        User user = userFacade.getCurrentUser();
        Post post = postFacade.getPostById(id);

        boolean isLiked = likeRepository.findById(LikeUserId
                .builder()
                .post(post.getId())
                .user(user.getId())
                .build())
                .isPresent();

        return PostInfoResponse.of(user, post, isLiked);
    }
}