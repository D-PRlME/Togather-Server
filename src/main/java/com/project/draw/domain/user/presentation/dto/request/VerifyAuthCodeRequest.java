package com.project.draw.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class VerifyAuthCodeRequest {

    @NotBlank
    @Size(min = 6, max = 6)
    private String authCode;

    @Email
    private String email;
}