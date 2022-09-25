package com.project.draw.domain.user.presentation.dto.request;


import com.project.draw.global.util.RegexpProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotBlank(message = "old_passwod는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    private String oldPassword;

    @NotBlank(message = "new_password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = RegexpProperty.PASSWORD, message = "password는 8-30자여야합니다.")
    private String newPassword;
}