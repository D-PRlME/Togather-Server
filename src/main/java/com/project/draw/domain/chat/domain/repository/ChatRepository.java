package com.project.draw.domain.chat.domain.repository;

import com.project.draw.domain.chat.domain.Chat;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByRoomIdOrderByIdAsc(Long roomId, Pageable pageable);
}