package com.project.draw.domain.chat.domain.repository;

import com.project.draw.domain.chat.domain.Chat;
import com.project.draw.domain.chat.domain.Room;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findTop100ByRoomAndCreatedAtBeforeOrderByIdAsc(Room room, LocalDateTime localDateTime);
}