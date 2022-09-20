package com.project.draw.domain.post.facade;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.repository.PostRepository;
import com.project.draw.domain.post.exception.InvalidUserException;
import com.project.draw.domain.post.exception.PostNotFoundException;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PostFacade {
    private final UserFacade userFacade;
    private final PostRepository postRepository;

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
    }

    public void checkUser(Post post) {
        if(!userFacade.getCurrentUser().equals(post.getUser()))
            throw InvalidUserException.EXCEPTION;
    }
}
