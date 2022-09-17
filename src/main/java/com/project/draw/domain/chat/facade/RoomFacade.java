package com.project.draw.domain.chat.facade;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.repository.RoomRepository;
import com.project.draw.domain.chat.exception.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomFacade {

    private final RoomRepository roomRepository;

    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }


}