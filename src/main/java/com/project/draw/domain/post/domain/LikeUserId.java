package com.project.draw.domain.post.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class LikeUserId implements Serializable {
    private Long post;
    private Long user;
}
