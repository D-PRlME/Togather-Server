package com.project.draw.util;

import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.project.domain.ProjectInvitation;
import com.project.draw.domain.user.domain.User;

public class ProjectInvitationBuilder {

    public static ProjectInvitation build(Project project, User user) {

        return ProjectInvitation
                .builder()
                .user(user)
                .project(project)
                .build();
    }
}