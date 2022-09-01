package com.project.draw.domain.user.domain;


import com.project.draw.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.project.draw.global.image.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(unique = true)
    private String accountId;

    @NotNull
    @Size(max = 40)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    @Size(max = 60)
    private String password;

    @ColumnDefault("'" + DefaultImage.USER_PROFILE_IMAGE + "'")
    private String profileImageUrl;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 7)
    private Authority authority;

    @Builder
    public User(String accountId, String email, String name, String password, String profileImageUrl, Authority authority) {
        this.accountId = accountId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.profileImageUrl = profileImageUrl;
        this.authority = authority;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateInfo(UpdateUserInfoRequest request) {
        this.profileImageUrl = request.getProfileImageUrl() == null ? DefaultImage.USER_PROFILE_IMAGE : getProfileImageUrl();
        this.name = request.getUsername();
    }

    public void updateEmail(String email) {
        this.email = email;
    }
}