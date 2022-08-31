package com.project.draw.domain.post.presentation;

import com.project.draw.domain.post.presentation.dto.request.CreatePostRequest;
import com.project.draw.domain.post.presentation.dto.request.UpdatePostRequest;
import com.project.draw.domain.post.presentation.dto.response.PostListResponse;
import com.project.draw.domain.post.service.CreatePostService;
import com.project.draw.domain.post.service.QueryMyPostService;
import com.project.draw.domain.post.service.QueryPostsService;
import com.project.draw.domain.post.service.UpdatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final CreatePostService createPostService;
    private final UpdatePostService updatePostService;
    private final QueryMyPostService queryMyPostService;
    private final QueryPostsService queryPostsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPost(@RequestBody @Valid CreatePostRequest request) {
        createPostService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{post-id}")
    public void updatePost(@PathVariable("post-id") Long id, @RequestBody @Valid UpdatePostRequest request) {
        updatePostService.execute(id, request);
    }

    @GetMapping("/my")
    public PostListResponse queryMyPosts() {
        return queryMyPostService.execute();
    }

    @GetMapping
    public PostListResponse queryPosts() {
        return queryPostsService.execute();
    }
}
