package com.project.draw.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
public class SendAuthCodeRequest {

    @Email
    private String email;
}