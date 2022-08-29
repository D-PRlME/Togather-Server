package com.project.draw.domain.post.presentation;

import com.project.draw.domain.post.presentation.dto.request.CreatePostRequest;
import com.project.draw.domain.post.service.CreatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final CreatePostService createPostService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPost(@RequestBody @Valid CreatePostRequest request) {
        createPostService.execute(request);
    }
}
