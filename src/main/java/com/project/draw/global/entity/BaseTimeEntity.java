package com.project.draw.global.entity;

import com.project.draw.global.util.date.DateUtil;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt = DateUtil.getZonedNow();
}