package com.project.draw.domain.chat.domain;

import com.project.draw.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(RoomUser.RoomUserId.class)
@Entity
public class RoomUser {

    @Id
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private ZonedDateTime lastRead = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

    @Builder
    public RoomUser(Room room, User user) {
        this.room = room;
        this.user = user;
    }

    public void updateLastReadTime() {
        this.lastRead = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @EqualsAndHashCode
    public static class RoomUserId implements Serializable {
        private Long room;
        private Long user;
    }

}