package com.project.draw.domain.project.domain.repository;

import com.project.draw.domain.project.domain.ProjectInvitation;
import com.project.draw.domain.project.domain.ProjectUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectInvitationRepository extends JpaRepository<ProjectInvitation, ProjectUserId> {
}