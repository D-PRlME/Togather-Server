package com.project.draw.util;

import com.project.draw.constant.RoomConstant;
import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.enums.RoomType;
import com.project.draw.domain.project.domain.Project;

import static org.springframework.test.util.ReflectionTestUtils.setField;

public class RoomBuilder {

    public static Room buildProjectRoom(Project project) {

        Room room = Room
                .builder()
                .project(Project.builder().build())
                .roomType(RoomType.PROJECT)
                .build();

        setField(room, "id", RoomConstant.ID);

        return room;
    }
}