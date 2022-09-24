package com.project.draw.global.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(nullable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
}