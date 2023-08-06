package com.whereu.likelionhackathon.domain.user.service;


import com.whereu.likelionhackathon.domain.guide.dto.GuideDTO;
import com.whereu.likelionhackathon.domain.guide.service.GuideService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("가이드에 관한 테스트")
public class GuideServiceTest {
    @Autowired
    GuideService guideService;

    @Test
    @DisplayName("모든 내용 출력")
    public void testFindAll() {
        guideService.findAll();
        System.out.println("모든 내용이 출력되었습니다.");
    }

    @Test
    @DisplayName("한개 내용 출력")
    public void testFindById() {
        GuideDTO guideDTO = guideService.findById(1L);
        System.out.println("출력 완료");
    }
}
