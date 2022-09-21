package com.project.draw.domain.project.presentation.dto.response;

import com.project.draw.domain.project.domain.Project;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProjectResponse {

    private final String name;
    private final String description;
    private final String projectLogoImage;

    public static ProjectResponse of(Project project) {
        return ProjectResponse
                .builder()
                .name(project.getName())
                .description(project.getDescription())
                .projectLogoImage(project.getLogoImage())
                .build();
    }
}