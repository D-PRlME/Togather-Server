package com.project.draw.domain.chat.facade;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.RoomUser;
import com.project.draw.domain.chat.domain.RoomUser.RoomUserId;
import com.project.draw.domain.chat.domain.repository.RoomUserRepository;
import com.project.draw.domain.chat.exception.RoomUserNotFoundException;
import com.project.draw.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class RoomUserFacade {

    private final RoomUserRepository roomUserRepository;

    public RoomUser getById(Long roomId, Long userId) {
        return roomUserRepository.findById(RoomUserId
                        .builder()
                        .room(roomId)
                        .user(userId)
                        .build())
                .orElseThrow(() -> RoomUserNotFoundException.EXCEPTION);
    }

    public RoomUser getById(RoomUserId roomUserId) {
        return roomUserRepository.findById(roomUserId)
                .orElseThrow(() -> RoomUserNotFoundException.EXCEPTION);
    }

    public List<RoomUser> getByUser(User user) {
        return roomUserRepository.findByUser(user);
    }


    public void checkRoomUserExist(Room room, User user) {

        Optional<RoomUser> optionalRoomUser = roomUserRepository.findById(RoomUserId
                .builder()
                .room(room.getId())
                .user(user.getId())
                .build());

        if (optionalRoomUser.isEmpty()) {
            throw RoomUserNotFoundException.EXCEPTION;
        }
    }
}