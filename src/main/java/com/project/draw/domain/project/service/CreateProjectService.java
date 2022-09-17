package com.project.draw.domain.project.service;

import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.enums.RoomType;
import com.project.draw.domain.chat.domain.repository.RoomRepository;
import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.project.domain.repository.ProjectRepository;
import com.project.draw.domain.project.presentation.dto.request.CreateProjectRequest;
import com.project.draw.domain.project.presentation.dto.response.CreateProjectResponse;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateProjectService {

    private final ProjectRepository projectRepository;
    private final RoomRepository roomRepository;
    private final UserFacade userFacade;

    @Transactional
    public CreateProjectResponse execute(CreateProjectRequest request) {

        User user = userFacade.getCurrentUser();

        Project project = projectRepository.save(Project
                .builder()
                .name(request.getName())
                .projectManager(user)
                .build());

        Room room = roomRepository.save(Room
                .builder()
                .roomType(RoomType.PROJECT)
                .project(project)
                .build());

        room.addRoomUser(user);

        return new CreateProjectResponse(project.getId());
    }

}