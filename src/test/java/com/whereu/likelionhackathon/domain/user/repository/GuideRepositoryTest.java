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
                {"침수", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent21.html?menuSeq=126"},
                {"태풍", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent02.html?menuSeq=126"},
                {"호우", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent18.html?menuSeq=126"},
                {"낙뢰" ,"https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent03.html?menuSeq=126"},
                {"강풍", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent04.html?menuSeq=126"},
                {"풍랑", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent19.html?menuSeq=126"},
                {"대설", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent05.html?menuSeq=126"},
                {"한파", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent06.html?menuSeq=126"},
                {"폭염", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent07.html?menuSeq=126"},
                {"황사", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent08.html?menuSeq=126"},
                {"지진", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent09.html?menuSeq=126"},
                {"해일", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent10.html?menuSeq=126"},
                {"지진해일", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent16.html?menuSeq=126"},
                {"화산폭발", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent11.html?menuSeq=126"},
                {"가뭄", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent12.html?menuSeq=126"},
                {"홍수", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent13.html?menuSeq=126"},
                {"해수면상승", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent17.html?menuSeq=126"},
                {"산사태", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent20.html?menuSeq=126"},
                {"자연우주물체추락", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent22.html?menuSeq=126"},
                {"우주전파재난", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent23.html?menuSeq=126"},
                {"조류대발생(녹조)", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent24.html?menuSeq=126"}
        };

        for (int i = 0; i < list.length; i++) {
            Guide guide = Guide.builder().keyword(list[i][0]).url(list[i][1]).build();
            guideRepository.save(guide);
        }

        System.out.println("저장 완료");
    }
}
