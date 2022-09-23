package com.project.draw.domain.project.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryMyInvitationResponse {

    private final List<ProjectResponse> projectList;
}