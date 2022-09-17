package com.project.draw.domain.project.domain.repository;

import com.project.draw.domain.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}