package com.project.draw.domain.post.domain.repository;

import com.project.draw.domain.post.domain.Like;
import com.project.draw.domain.post.domain.LikeUserId;
import com.project.draw.domain.post.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, LikeUserId> {
    void deleteAllByPost(Post post);
}
