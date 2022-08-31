package com.project.draw.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class CheckEmailRequest {

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    private String email;

}