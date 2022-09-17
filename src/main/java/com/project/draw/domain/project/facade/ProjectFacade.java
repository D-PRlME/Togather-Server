package com.project.draw.domain.project.facade;

import com.project.draw.domain.project.domain.Project;
import com.project.draw.domain.project.domain.repository.ProjectRepository;
import com.project.draw.domain.user.domain.User;
import com.project.draw.global.exception.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProjectFacade {

    private final ProjectRepository projectRepository;

    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow();
    }

    public void checkProjectManager(Project project, User user) {
        if(project.getProjectManager() != user) {
            throw ForbiddenException.EXCEPTION;
        }
    }
}