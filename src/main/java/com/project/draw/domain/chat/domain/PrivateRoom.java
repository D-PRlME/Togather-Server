package com.project.draw.domain.chat.domain;

import com.project.draw.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(PrivateRoom.PrivateRoomId.class)
@Entity
public class PrivateRoom {

    @Id
    @JoinColumn(name = "user1_id")
    @ManyToOne
    private User user1;

    @Id
    @JoinColumn(name = "user2_id")
    @ManyToOne
    private User user2;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public PrivateRoom(User userA, User userB, Room room) {
        this.room = room;
        if(userA.getId() < userB.getId()){
            this.user1 = userA;
            this.user2 = userB;
        } else {
            this.user1 = userB;
            this.user2 = userA;
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @EqualsAndHashCode
    public static class PrivateRoomId implements Serializable {
        private Long user1;
        private Long user2;

        public PrivateRoomId(Long userA, Long userB) {
            if(userA < userB){
                this.user1 = userA;
                this.user2 = userB;
            } else {
                this.user1 = userB;
                this.user2 = userA;
            }
        }
    }
}