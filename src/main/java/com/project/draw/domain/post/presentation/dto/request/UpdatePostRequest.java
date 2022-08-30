package com.project.draw.domain.post.presentation.dto.request;

import com.project.draw.domain.post.domain.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
public class UpdatePostRequest {

    @Size(min = 1, max = 30, message = "제목은 최소 1자 ~ 최대 30자 내외입니다.")
    private String title;

    @Size(min = 1, max = 1000, message = "내용은 최소 1자 ~ 최대 1000자 내외입니다.")
    private String content;

    private List<Tag> tags;

    private String link;
}
