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
                .title("침수")
                .content("호우예보시\n" +
                        "ㆍ 저지대, 상습침수지역에 거주하고 계신 주민은 대피를 준비합시다.\n" +
                        "ㆍ 침수나 산사태 위험지역 주민은 대피장소와 비상연락방법을 미리 알아둡시다.\n" +
                        "ㆍ 하천에 주차된 자동차는 안전한 곳으로 이동합시다.")
                .keyword("침수")
                .build();
        guideRepository.save(guide);

        System.out.println("저장 완료");

    }
}
