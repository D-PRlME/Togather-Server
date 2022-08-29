package com.project.draw.domain.user.domain.repository;

import com.project.draw.domain.user.domain.AuthCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthCodeRepository extends CrudRepository<AuthCode, String> {
}