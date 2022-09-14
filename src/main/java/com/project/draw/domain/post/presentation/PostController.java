package com.project.draw.domain.post.presentation;

import com.project.draw.domain.post.presentation.dto.request.CreatePostRequest;
import com.project.draw.domain.post.presentation.dto.request.UpdatePostRequest;
import com.project.draw.domain.post.presentation.dto.response.PostInfoResponse;
import com.project.draw.domain.post.presentation.dto.response.PostListResponse;
import com.project.draw.domain.post.presentation.dto.response.TagListResponse;
import com.project.draw.domain.post.service.CreatePostService;
import com.project.draw.domain.post.service.DeletePostService;
import com.project.draw.domain.post.service.QueryMyPostService;
import com.project.draw.domain.post.service.QueryPostByKeywordService;
import com.project.draw.domain.post.service.QueryPostByTagService;
import com.project.draw.domain.post.service.QueryPostInfoService;
import com.project.draw.domain.post.service.QueryPostsService;
import com.project.draw.domain.post.service.QueryTagsService;
import com.project.draw.domain.post.service.UpdatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final CreatePostService createPostService;

    private final UpdatePostService updatePostService;

    private final QueryMyPostService queryMyPostService;
    private final QueryPostsService queryPostsService;
    private final QueryPostInfoService queryPostInfoService;
    private final QueryPostByTagService queryPostByTagService;
    private final QueryPostByKeywordService queryPostByKeywordService;

    private final DeletePostService deletePostService;
    private final QueryTagsService queryTagsService;

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

    @GetMapping("/{post-id}")
    public PostInfoResponse queryPostInfo(@PathVariable("post-id") Long id) {
        return queryPostInfoService.execute(id);
    }

    @GetMapping("/tag/list")
    public TagListResponse queryTagsService() {
        return queryTagsService.execute();
    }

    @GetMapping("/tag")
    public PostListResponse queryPostByTag(@RequestParam(value = "tag")String tag) {
        return queryPostByTagService.execute(tag);
    }

    @GetMapping("/title")
    public PostListResponse queryPostByKeyword(@RequestParam(value = "title")String keyword) {
        return queryPostByKeywordService.execute(keyword);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{post-id}")
    public void deletePost(@PathVariable("post-id")Long id) {
        deletePostService.execute(id);
    }
}