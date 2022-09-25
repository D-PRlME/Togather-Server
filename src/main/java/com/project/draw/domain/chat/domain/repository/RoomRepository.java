package com.project.draw.domain.chat.domain.repository;

import com.project.draw.domain.chat.domain.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}