package com.project.draw.domain.post.service;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.Tag;
import com.project.draw.domain.post.domain.repository.PostRepository;
import com.project.draw.domain.post.exception.BadTagException;
import com.project.draw.domain.post.presentation.dto.request.CreatePostRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CreatePostService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreatePostRequest request) {

        User user = userFacade.getCurrentUser();

        try {
            List<Tag> tags = request.getTags()
                    .stream()
                    .map(Tag::valueOf)
                    .collect(Collectors.toList());

            savePost(request, tags, user);

        } catch (IllegalArgumentException e) {
            throw BadTagException.EXCEPTION;
        }
    }

    private void savePost(CreatePostRequest request, List<Tag> tags, User user) {
        postRepository.save(
                Post.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .tags(tags)
                        .link(request.getLink())
                        .user(user)
                        .build()
        );
    }
}