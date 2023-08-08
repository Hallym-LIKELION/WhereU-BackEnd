package com.whereu.likelionhackathon.domain.guide.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuideDTO {
    private Long gid;
    private String title;
    private String content;
    private String keyword;
}
