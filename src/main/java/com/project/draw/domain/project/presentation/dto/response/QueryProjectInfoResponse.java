package com.project.draw.domain.project.presentation.dto.response;

import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.project.domain.ProjectUser;
import com.project.draw.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class QueryProjectInfoResponse {

    private String name;

    private String description;

    private String projectLogoImage;

    private UserResponse projectManager;

    private List<UserResponse> projectUsers;

    public static QueryProjectInfoResponse of(Project project) {

        return QueryProjectInfoResponse
                .builder()
                .name(project.getName())
                .description(project.getDescription())
                .projectLogoImage(project.getLogoImage())
                .projectManager(UserResponse.of(project.getProjectManager()))
                .projectUsers(project.getProjectUsers()
                        .stream()
                        .map(ProjectUser::getUser)
                        .map(UserResponse::of)
                        .collect(Collectors.toList()))
                .build();
    }
}