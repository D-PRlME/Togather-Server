package com.project.draw.domain.post.domain.repository;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByUserOrderByCreatedAtAsc(User user); //자신이 만든 게시글 조회

    List<Post> findAllByOrderByCreatedAtAsc(); //전체조회 시 시간순

    List<Post> findAllByTitleContains(String title); //검색어로 조회

    List<Post> findAllByTags(List<Tag> tags); //태그별로 조회
}
