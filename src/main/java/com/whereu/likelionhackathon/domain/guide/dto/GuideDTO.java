package com.whereu.likelionhackathon.domain.guide.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GuideDTO {
    private Long gid;
    private String title;
    private String content;
    private String keyword;
}
