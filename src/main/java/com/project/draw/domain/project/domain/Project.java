package com.project.draw.domain.project.domain;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.user.domain.User;
import com.project.draw.global.image.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @ColumnDefault("'"+ DefaultImage.PROJECT_DEFAULT_IMAGE +"'")
    private String logoImage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User projectManager;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "project")
    private List<ProjectUser> projectUsers;

    public void addProjectUsers(User user) {
        this.projectUsers.add(ProjectUser
                .builder()
                .project(this)
                .user(user)
                .build()
        );
    }

    @Builder
    public Project(String name, String description, String logoImage, User projectManager) {
        this.name = name;
        this.description = description;
        this.logoImage = logoImage;
        this.projectManager = projectManager;
    }

}