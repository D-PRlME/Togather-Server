package com.project.draw.domain.post.presentation;

import com.project.draw.domain.post.service.AddLikeService;
import com.project.draw.domain.post.service.DeleteLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class LikeController {
    private final AddLikeService addLikeService;
    private final DeleteLikeService deleteLikeService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/like/{post-id}")
    public void addLike(@PathVariable ("post-id") Long id) {
        addLikeService.execute(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/like/{post-id}")
    public void deleteLike(@PathVariable ("post-id") Long id) {
        deleteLikeService.execute(id);
    }
}
