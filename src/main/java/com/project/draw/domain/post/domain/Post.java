package com.project.draw.domain.post.domain;

import com.project.draw.domain.user.domain.User;
import com.project.draw.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Tag> tags = new ArrayList<>();

    @Column(nullable = false)
    private String link;

    @NotNull
    private boolean isComplete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likeList;

    @Builder
    public Post(String title, String content, List<Tag> tags, String link, User user) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.link = link;
        this.user = user;
        this.isComplete = false;
    }


    public void updatePost(String title, String content, List<Tag> tags, String link, boolean isComplete) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.link = link;
        this.isComplete = isComplete;
    }

    public void addLike(Like like) {
        this.likeList.add(Like
                .builder()
                .post(this)
                .user(user)
                .build());
    }
}
