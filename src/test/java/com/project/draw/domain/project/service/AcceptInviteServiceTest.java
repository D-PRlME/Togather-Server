package com.project.draw.domain.project.service;

import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.project.domain.ProjectInvitation;
import com.project.draw.domain.project.domain.repository.ProjectInvitationRepository;
import com.project.draw.domain.project.exception.UserNotInvitedException;
import com.project.draw.domain.project.presentation.dto.request.AcceptInviteRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class AcceptInviteServiceTest {

    @Mock
    private UserFacade userFacade;

    @Mock
    private ProjectInvitationRepository projectInvitationRepository;

    @InjectMocks
    private AcceptInviteService service;

    @Test
    public void 프로젝트_초대_수락() {
        //given
        User user = User.builder().build();
        Project project = Project.builder().build();
        setField(project, "projectUsers", new ArrayList<>());

        ProjectInvitation projectInvitation = ProjectInvitation
                .builder()
                .project(project)
                .build();

        given(userFacade.getCurrentUser()).willReturn(user);
        given(projectInvitationRepository.findById(any())).willReturn(Optional.of(projectInvitation));

        AcceptInviteRequest request = new AcceptInviteRequest();
        setField(request, "isAccept", true);

        //when
        service.execute(request);

        //then
        then(projectInvitationRepository).should(times(1)).delete(projectInvitation);
    }

    @Test
    public void 프로젝트_초대_거절() {
        //given
        User user = User.builder().build();
        Project project = Project.builder().build();
        setField(project, "projectUsers", new ArrayList<>());

        ProjectInvitation projectInvitation = ProjectInvitation
                .builder()
                .project(project)
                .build();

        given(userFacade.getCurrentUser()).willReturn(user);
        given(projectInvitationRepository.findById(any())).willReturn(Optional.of(projectInvitation));

        AcceptInviteRequest request = new AcceptInviteRequest();
        setField(request, "isAccept", false);

        //when
        service.execute(request);

        //then
        then(projectInvitationRepository).should(times(1)).delete(projectInvitation);
    }

    @Test
    public void 프로젝트_초대_수락_실패() {

        //given
        User user = User.builder().build();
        Project project = Project.builder().build();
        setField(project, "projectUsers", new ArrayList<>());

        given(userFacade.getCurrentUser()).willReturn(user);
        given(projectInvitationRepository.findById(any())).willReturn(null);

        AcceptInviteRequest request = new AcceptInviteRequest();

        //when then
        assertThrows(UserNotInvitedException.class, () -> service.execute(request));
    }

}