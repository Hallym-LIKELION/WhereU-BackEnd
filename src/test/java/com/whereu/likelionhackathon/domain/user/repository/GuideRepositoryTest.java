package com.whereu.likelionhackathon.domain.user.repository;

import com.whereu.likelionhackathon.domain.guide.entity.Guide;
import com.whereu.likelionhackathon.domain.guide.repository.GuideRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("가이드관련 Repository 테스트")
public class GuideRepositoryTest {
    @Autowired
    GuideRepository guideRepository;

    @Test
    @DisplayName("가이드 내용 저장")
    public void guideSave() {
        Guide guide = Guide.builder()
                .keyword("침수")
                .build();
        guideRepository.save(guide);

        System.out.println("저장 완료");

    }
}
