package com.project.draw.domain.post.domain.repository;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.Tag;
import com.project.draw.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByUserOrderByCreatedAtAsc(User user); //자신이 만든 게시글 조회

    List<Post> findAllByOrderByCreatedAtAsc(); //전체조회 시 시간순

    List<Post> findAllByTitleContains(String title); //검색어로 조회

    List<Post> findAllByTagsContainsOrderByCreatedAtAsc(Tag tag); //태그별로 조회
}
