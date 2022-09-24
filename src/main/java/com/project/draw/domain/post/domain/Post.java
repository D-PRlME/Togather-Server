package com.project.draw.domain.post.domain;

import com.project.draw.domain.user.domain.User;
import com.project.draw.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @BatchSize(size = 50)
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Tag> tags = new ArrayList<>();

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private boolean isComplete = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes;

    @Builder
    public Post(String title, String content, List<Tag> tags, String link, User user) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.link = link;
        this.user = user;
    }

    public void updatePost(String title, String content, List<Tag> tags, String link, boolean isComplete) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.link = link;
        this.isComplete = isComplete;
    }
}