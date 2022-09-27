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
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

    @Column(nullable = false)
    private RoomType roomType;

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<RoomUser> roomUsers = new ArrayList<>();

    @OneToOne(mappedBy = "room")
    private Project project;

    @OneToOne(mappedBy = "room")
    private PrivateRoom privateRoom;

    @Embedded
    @Column(nullable = false)
    private LastChat lastChat;

    public String getRoomName(User user) {

        if (roomType == RoomType.TEAM) {
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

        if (roomType == RoomType.TEAM) {
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
    public Room(RoomType roomType, Project project, PrivateRoom privateRoom) {
        this.roomType = roomType;
        this.project = project;
        this.privateRoom = privateRoom;
        this.lastChat = new LastChat();
    }

    public void updateLastMessage(Chat chat) {
        this.lastChat.lastMessage = chat.getMessage();
        this.lastChat.lastSentAt = chat.getCreatedAt();
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Embeddable
    public static class LastChat {
        private String lastMessage = "";
        private ZonedDateTime lastSentAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    }
}