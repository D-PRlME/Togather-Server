package com.project.draw.domain.post.domain.repository;

import com.project.draw.domain.post.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
