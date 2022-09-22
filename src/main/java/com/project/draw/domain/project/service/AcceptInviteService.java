package com.project.draw.domain.project.service;

import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.project.domain.ProjectInvitation;
import com.project.draw.domain.project.domain.ProjectUserId;
import com.project.draw.domain.project.domain.repository.ProjectInvitationRepository;
import com.project.draw.domain.project.exception.UserNotInvitedException;
import com.project.draw.domain.project.presentation.dto.request.AcceptInviteRequest;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AcceptInviteService {

    private final ProjectInvitationRepository projectInvitationRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(AcceptInviteRequest request) {

        User user =  userFacade.getCurrentUser();

        ProjectInvitation projectInvitation = projectInvitationRepository.findById(ProjectUserId
                        .builder()
                        .user(user.getId())
                        .project(request.getProjectId())
                        .build())
                .orElseThrow(() -> UserNotInvitedException.EXCEPTION);

        if (request.getIsAccept()) {
            joinProject(projectInvitation.getProject(), user);
        }

        projectInvitationRepository.delete(projectInvitation);
    }

    private void joinProject(Project project, User user) {
        project.addProjectUsers(user);
    }

}