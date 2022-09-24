package com.project.draw.domain.user.presentation.dto.request;

import com.project.draw.domain.user.domain.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    @NotBlank(message = "username은 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    private String userName;

    private String profileImageUrl;

    @Size(max = 1000)
    private String introduce;
    
    private List<Position> positions;
}