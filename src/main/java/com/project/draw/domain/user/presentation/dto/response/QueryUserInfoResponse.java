package com.project.draw.domain.user.presentation.dto.response;

import com.project.draw.domain.user.domain.Position;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QueryUserInfoResponse {

    private final String name;
    private final String email;
    private final String profileImageUrl;
    private final List<Position> positions;
    private final String introduce;
}