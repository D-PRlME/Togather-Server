package com.project.draw.util;

import com.project.draw.constant.ProjectConstant;
import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.user.domain.User;

import static org.springframework.test.util.ReflectionTestUtils.setField;

public class ProjectBuilder {

    public static Project build(User projectManager) {

        Project project = Project.builder()
                .name(ProjectConstant.NAME)
                .logoImage(ProjectConstant.LOGO_IMAGE)
                .description(ProjectConstant.DESCRIPTION)
                .projectManager(projectManager)
                .build();

        setField(project, "id", ProjectConstant.ID);

        return project;
    }
}