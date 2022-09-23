package com.project.draw.domain.project.domain.repository;

import com.project.draw.domain.project.domain.ProjectInvitation;
import com.project.draw.domain.project.domain.ProjectUserId;
import com.project.draw.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectInvitationRepository extends JpaRepository<ProjectInvitation, ProjectUserId> {

    List<ProjectInvitation> findByUser(User user);
}