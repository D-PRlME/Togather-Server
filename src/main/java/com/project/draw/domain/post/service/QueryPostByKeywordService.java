package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.repository.PostRepository;
import com.project.draw.domain.post.presentation.dto.response.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryPostByKeywordService {
    private final PostRepository postRepository;

    @Transactional
    public PostListResponse execute(String keyword) {
            List<PostListResponse.PostResponse> postList = postRepository.findAllByTitleContainsOrderByCreatedAtAsc(keyword)
                    .stream()
                    .map(this::postBuilder)
                    .collect(Collectors.toList());

            return new PostListResponse(postList);
        }

        private PostListResponse.PostResponse postBuilder(Post post) {
            return PostListResponse.PostResponse.builder()
                    .title(post.getTitle())
                    .tags(post.getTags())
                    .user_name(post.getUser().getName())
                    .createdAt(post.getCreatedAt())
                    .build();
        }
}
