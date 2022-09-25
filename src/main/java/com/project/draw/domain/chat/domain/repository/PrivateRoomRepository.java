package com.project.draw.domain.chat.domain.repository;

import com.project.draw.domain.chat.domain.PrivateRoom;
import com.project.draw.domain.chat.domain.PrivateRoom.PrivateRoomId;
import org.springframework.data.repository.CrudRepository;

public interface PrivateRoomRepository extends CrudRepository<PrivateRoom, PrivateRoomId> {
}