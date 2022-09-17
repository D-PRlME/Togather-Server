package com.project.draw.domain.chat.domain.repository;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.enums.RoomType;
import com.project.draw.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Long> {
    Optional<Room> findByIdAndRoomUsers_user(Long id, User user);
    Optional<Room> findByRoomTypeAndRoomUsers_user(RoomType roomType, User user);
}