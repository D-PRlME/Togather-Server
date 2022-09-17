package com.project.draw.domain.project.service;

import com.project.draw.constant.ProjectConstant;
import com.project.draw.domain.chat.domain.Room;
import com.project.draw.domain.chat.domain.repository.RoomRepository;
import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.project.domain.repository.ProjectRepository;
import com.project.draw.domain.project.presentation.dto.request.CreateProjectRequest;
import com.project.draw.domain.project.presentation.dto.response.CreateProjectResponse;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.util.ProjectBuilder;
import com.project.draw.util.RoomBuilder;
import com.project.draw.util.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class CreateProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private UserFacade userFacade;

    @InjectMocks
    private CreateProjectService service;

    static private Project project;
    static private User user;
    static private Room room;

    @BeforeAll
    static void setUp() {
        user = UserBuilder.build();
        project = ProjectBuilder.build(user);
        room = RoomBuilder.buildProjectRoom(project);
    }

    @Test
    public void 프로젝트_생성_성공() {
        //given
        CreateProjectRequest request = new CreateProjectRequest();
        given(userFacade.getCurrentUser()).willReturn(user);
        given(projectRepository.save(any())).willReturn(project);
        given(roomRepository.save(any())).willReturn(room);

        //when
        CreateProjectResponse response = service.execute(request);

        //then
        then(projectRepository).should(times(1)).save(any());
        then(roomRepository).should(times(1)).save(any());
        Assertions.assertEquals(response.getProjectId(), ProjectConstant.ID);
    }
}