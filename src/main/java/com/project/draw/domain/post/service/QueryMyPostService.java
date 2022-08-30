package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.repository.PostRepository;
import com.project.draw.domain.post.presentation.dto.response.PostListResponse;
import com.project.draw.domain.post.presentation.dto.response.PostListResponse.PostResponse;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryMyPostService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public PostListResponse execute() {
        List<PostResponse> myPostList = postRepository.findAllByUserOrderByCreatedAtAsc(userFacade.getCurrentUser())
                .stream()
                .map(this::postBuilder)
                .collect(Collectors.toList());

        return new PostListResponse(myPostList);
    }

    private PostResponse postBuilder(Post post) {
        return PostResponse.builder()
                .title(post.getTitle())
                .tags(post.getTags())
                .user_name(post.getUser().getName())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
