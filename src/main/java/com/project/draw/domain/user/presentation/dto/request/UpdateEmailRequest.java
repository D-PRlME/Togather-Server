package com.project.draw.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UpdateEmailRequest {

    @NotBlank(message = "이메일은 null을 허용하지 않습니다.")
    private String newEmail;
}