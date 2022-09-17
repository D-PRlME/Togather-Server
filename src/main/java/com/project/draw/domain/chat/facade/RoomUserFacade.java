package com.project.draw.domain.chat.facade;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.repository.RoomUserRepository;
import com.project.draw.domain.chat.exception.RoomUserNotFoundException;
import com.project.draw.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomUserFacade {

    private final RoomUserRepository roomUserRepository;

    public void checkRoomUserExist(Room room, User user){
        if(!roomUserRepository.existsByRoomAndUser(room, user)) {
            throw RoomUserNotFoundException.EXCEPTION;
        }
    }
}