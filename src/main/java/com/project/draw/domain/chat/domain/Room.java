package com.project.draw.domain.chat.domain;

import com.project.draw.domain.chat.domain.enums.RoomType;
import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.exception.UserNotFoundException;
import com.project.draw.global.image.DefaultImage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    private RoomType roomType;

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<RoomUser> roomUsers = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public String getRoomName(User user) {

        if (roomType == RoomType.PROJECT) {
            return project.getName();
        } else {
            try{
                return getOtherUser(user).getName();
            } catch (UserNotFoundException e) {
                return "알 수 없는 유저";
            }
        }
    }

    public String getRoomImage(User user) {

        if (roomType == RoomType.PROJECT) {
            return project.getLogoImage();
        } else {
            try{
                return getOtherUser(user).getProfileImageUrl();
            } catch (UserNotFoundException e) {
                return DefaultImage.USER_PROFILE_IMAGE;
            }
        }
    }

    private User getOtherUser(User user) {
        if(roomUsers.size() < 2){
            throw UserNotFoundException.EXCEPTION;
        }
        User user1 = roomUsers.get(0).getUser();
        User user2 = roomUsers.get(1).getUser();
        return user1 != user ? user1 : user2;
    }


    public void addRoomUser(User user) {
        this.roomUsers.add(RoomUser
                .builder()
                .room(this)
                .user(user)
                .build());
    }

    @Builder
    public Room(RoomType roomType, Project project) {
        this.roomType = roomType;
        this.project = project;
    }
}