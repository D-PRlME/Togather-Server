package com.project.draw.domain.user.domain;


import com.project.draw.domain.chat.domain.PrivateRoom;
import com.project.draw.domain.post.domain.Like;
import com.project.draw.domain.post.domain.Post;
import com.project.draw.domain.user.domain.enums.Authority;
import com.project.draw.domain.user.domain.enums.Position;
import com.project.draw.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.project.draw.global.image.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@BatchSize(size = 500)
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 40)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 30)
    private String name;

    @Size(max = 60)
    private String password;

    @ColumnDefault("'" + DefaultImage.USER_PROFILE_IMAGE + "'")
    private String profileImageUrl;

    @NotNull
    @BatchSize(size = 50)
    @Enumerated(EnumType.STRING)
    @Column(length = 7)
    private Authority authority;

    @Column(length = 1000, nullable = false)
    private String introduce;

    @BatchSize(size = 50)
    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<Position> positions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Post> post;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Like> likes;

    @OneToMany(mappedBy = "user1", cascade = CascadeType.REMOVE)
    private List<PrivateRoom> privateRooms1;

    @OneToMany(mappedBy = "user2", cascade = CascadeType.REMOVE)
    private List<PrivateRoom> privateRooms2;

    @Builder
    public User(String email, String name, String password, String profileImageUrl, Authority authority, String introduce) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.profileImageUrl = profileImageUrl;
        this.authority = authority;
        this.introduce = introduce;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateInfo(UpdateUserInfoRequest request) {
        this.profileImageUrl = request.getProfileImageUrl();
        this.name = request.getUserName();
        this.introduce = request.getIntroduce();
        this.positions = request.getPositions();
    }

}