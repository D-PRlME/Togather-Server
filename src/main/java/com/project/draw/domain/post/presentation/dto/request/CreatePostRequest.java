package com.project.draw.domain.post.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreatePostRequest {

    @NotNull(message = "title은 null일 수 없습니다")
    @Size(min = 1, max = 30, message = "제목은 최소 1자 ~ 최대 30자 내외입니다.")
    private String title;

    @NotNull(message = "content는 null일 수 없습니다")
    @Size(min = 1, max = 1000, message = "내용은 최소 1자 ~ 최대 1000자 내외입니다.")
    private String content;

    @NotNull(message = "tags는 null일 수 없습니다")
    private List<String> tags;
}