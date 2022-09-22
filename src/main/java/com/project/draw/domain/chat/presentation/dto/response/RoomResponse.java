package com.project.draw.domain.chat.presentation.dto.response;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.enums.RoomType;
import com.project.draw.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomResponse {

    private Long roomId;
    private String roomName;
    private String roomLogoImage;
    private RoomType roomType;

    public static RoomResponse of(User user, Room room) {

        return RoomResponse
                .builder()
                .roomId(room.getId())
                .roomName(room.getRoomName(user))
                .roomLogoImage(room.getRoomImage(user))
                .roomType(room.getRoomType())
                .build();
    }


}