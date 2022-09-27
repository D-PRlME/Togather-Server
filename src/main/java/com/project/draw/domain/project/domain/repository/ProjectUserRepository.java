package com.project.draw.domain.project.domain.repository;

import com.project.draw.domain.project.domain.ProjectUser;
import com.project.draw.domain.project.domain.ProjectUser.ProjectUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectUserRepository extends JpaRepository<ProjectUser, ProjectUserId> {
}