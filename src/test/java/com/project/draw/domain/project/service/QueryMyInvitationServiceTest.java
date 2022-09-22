package com.project.draw.domain.project.service;

import com.project.draw.domain.project.domain.repository.ProjectInvitationRepository;
import com.project.draw.domain.project.presentation.dto.response.ProjectResponse;
import com.project.draw.domain.project.presentation.dto.response.QueryMyInvitationResponse;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QueryMyInvitationServiceTest {

    @Mock
    private UserFacade userFacade;

    @Mock
    private ProjectInvitationRepository projectInvitationRepository;

    @InjectMocks
    private QueryMyInvitationService service;

    @Test
    public void 프로젝트_초대장_조회() {
        //given
        User user = User.builder().build();
        List<ProjectResponse> projectList = new ArrayList<>();

        given(userFacade.getCurrentUser()).willReturn(user);
        given(projectInvitationRepository.findByUser(user)).willReturn(new ArrayList<>());

        //when
        QueryMyInvitationResponse response = service.execute();

        //then
        assertThat(response.getProjectList()).usingRecursiveComparison().isEqualTo(projectList);
    }

}