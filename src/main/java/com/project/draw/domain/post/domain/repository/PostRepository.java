package com.project.draw.domain.post.domain.repository;

import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.post.domain.enums.Tag;
import com.project.draw.domain.user.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByUser(User user, Sort sort);

    List<Post> findBy(Sort sort);

    List<Post> findByTitleContains(String keyword, Sort sort);

    List<Post> findByTagsContains(Tag tag, Sort sort);

}