package com.project.draw.domain.chat.domain.repository;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.RoomUser;
import com.project.draw.domain.chat.domain.RoomUser.RoomUserId;
import com.project.draw.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomUserRepository extends CrudRepository<RoomUser, RoomUserId> {

    List<RoomUser> findByUser(User user);
    boolean existsByRoomAndUser(Room room, User user);
}