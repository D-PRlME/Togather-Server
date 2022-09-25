package com.project.draw.domain.user.presentation.dto.request;

import com.project.draw.global.util.RegexpProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class SendAuthCodeRequest {

    @Pattern(regexp = RegexpProperty.EMAIL)
    private String email;
}