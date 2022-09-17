package com.project.draw.domain.project.service;

import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.project.domain.ProjectInvitation;
import com.project.draw.domain.project.domain.repository.ProjectInvitationRepository;
import com.project.draw.domain.project.facade.ProjectFacade;
import com.project.draw.domain.project.presentation.dto.request.InviteUserRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InviteUserService {

    private final ProjectInvitationRepository projectInvitationRepository;
    private final ProjectFacade projectFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(InviteUserRequest request) {

        User user = userFacade.getCurrentUser();
        Long projectId = request.getProjectId();

        Project project = projectFacade.getProjectById(projectId);
        projectFacade.checkProjectManager(project, user);

        User userToInvite = userFacade.getUserById(request.getUserId());

        ProjectInvitation projectInvitation = projectInvitationRepository.save(ProjectInvitation
                .builder()
                .user(userToInvite)
                .project(project)
                .build());
    }
}