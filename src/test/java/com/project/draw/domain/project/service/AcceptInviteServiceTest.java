package com.project.draw.domain.project.service;

import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.project.domain.ProjectInvitation;
import com.project.draw.domain.project.domain.repository.ProjectInvitationRepository;
import com.project.draw.domain.project.exception.UserNotInvitedException;
import com.project.draw.domain.project.presentation.dto.request.AcceptInviteRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import com.project.draw.util.ProjectBuilder;
import com.project.draw.util.ProjectInvitationBuilder;
import com.project.draw.util.UserBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AcceptInviteServiceTest {

    @Mock
    private ProjectInvitationRepository projectInvitationRepository;

    @Mock
    private UserFacade userFacade;

    @InjectMocks
    private AcceptInviteService service;

    static private User user;
    static private ProjectInvitation projectInvitation;

    @BeforeAll
    static void setUp() {
        user = UserBuilder.build();
        Project project = ProjectBuilder.build(user);
        projectInvitation = ProjectInvitationBuilder.build(project, user);
    }

    @Test
    public void 프로젝트_초대_수락 () {
        //given
        AcceptInviteRequest request = new AcceptInviteRequest();
        given(userFacade.getCurrentUser())
                .willReturn(user);
        given(projectInvitationRepository.findById(any()))
                .willReturn(Optional.of(projectInvitation));

        //when
        service.execute(request);

        //then
        then(projectInvitationRepository).should(times(1)).findById(any());
        verify(projectInvitation.getProject(), times(1)).addProjectUsers(user);
        then(projectInvitationRepository).should(times(1)).delete(projectInvitation);
    }


    @Test
    public void 프로젝트_초대_없음_실패 () {
        //given
        AcceptInviteRequest request = new AcceptInviteRequest();
        given(userFacade.getCurrentUser())
                .willReturn(user);
        given(projectInvitationRepository.findById(any()))
                .willReturn(Optional.empty());

        //when then
        assertThrows(UserNotInvitedException.class, () -> service.execute(request));
    }

}