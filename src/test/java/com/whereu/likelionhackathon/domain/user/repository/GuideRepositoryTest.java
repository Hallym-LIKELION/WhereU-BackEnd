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
        String[][] list = {
                {"태풍", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent02.html?menuSeq=126"},
                {"호우", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent18.html?menuSeq=126"},
                {"강풍", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent04.html?menuSeq=126"},
                {"풍랑", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent19.html?menuSeq=126"},
                {"대설", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent05.html?menuSeq=126"},
                {"한파", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent06.html?menuSeq=126"},
                {"폭염", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent07.html?menuSeq=126"},
                {"황사", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent08.html?menuSeq=126"},
                {"폭풍해일", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent10.html?menuSeq=126"},
                {"건조, 산불", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/SDIJKM5117.html?menuSeq=127"}
        };

        for (int i = 0; i < list.length; i++) {
            Guide guide = Guide.builder().keyword(list[i][0]).url(list[i][1]).build();
            guideRepository.save(guide);
        }

        System.out.println("저장 완료");
    }
}
