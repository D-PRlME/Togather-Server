package com.project.draw.domain.project.service;

import com.project.draw.domain.project.domain.repository.ProjectInvitationRepository;
import com.project.draw.domain.project.presentation.dto.response.ProjectResponse;
import com.project.draw.domain.project.presentation.dto.response.QueryMyInvitationResponse;
import com.project.draw.domain.user.domain.User;
import com.project.draw.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryMyInvitationService {

    private final UserFacade userFacade;
    private final ProjectInvitationRepository projectInvitationRepository;

    @Transactional(readOnly = true)
    public QueryMyInvitationResponse execute() {

        User user = userFacade.getCurrentUser();

        return new QueryMyInvitationResponse(
                projectInvitationRepository.findByUser(user)
                        .stream()
                        .map(invitation -> ProjectResponse.of(invitation.getProject()))
                        .collect(Collectors.toList())
        );
    }
}