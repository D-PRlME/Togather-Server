package com.project.draw.domain.chat.domain.repository;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.RoomUser;
import com.project.draw.domain.chat.domain.RoomUserId;
import com.project.draw.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomUserRepository extends JpaRepository<RoomUser, RoomUserId> {

    boolean existsByRoomAndUser(Room room, User user);
}