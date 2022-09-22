package com.project.draw.domain.project.service;

import com.project.draw.domain.project.domain.repository.ProjectInvitationRepository;
import com.project.draw.domain.project.facade.ProjectFacade;
import com.project.draw.domain.project.presentation.dto.request.InviteUserRequest;
import com.project.draw.domain.user.facade.UserFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class InviteUserServiceTest {

    @Mock
    private ProjectInvitationRepository projectInvitationRepository;

    @Mock
    private ProjectFacade projectFacade;

    @Mock
    private UserFacade userFacade;

    @InjectMocks
    private InviteUserService inviteUserService;

    @Test
    public void 유저_초대_성공() {
        //given
        InviteUserRequest request = new InviteUserRequest();
        //when
        inviteUserService.execute(request);
        //then
        then(projectInvitationRepository).should(times(1)).save(any());
    }

}