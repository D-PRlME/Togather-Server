package com.project.draw.domain.post.domain.repository;

import com.project.draw.domain.post.domain.Like;
import com.project.draw.domain.post.domain.LikeUserId;
import com.project.draw.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, LikeUserId> {
    Optional<Like> deleteAllByPost(Post post);
}
