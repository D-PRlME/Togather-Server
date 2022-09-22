package com.project.draw.domain.project.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class AcceptInviteRequest {

    @NotNull(message = "project_id은 null를 허용하지 않습니다.")
    private Long projectId;

    @NotNull(message = "is_accept는 null를 허용하지 않습니다.")
    private Boolean isAccept;
}