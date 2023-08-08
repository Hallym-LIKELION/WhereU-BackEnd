package com.whereu.likelionhackathon.domain.user.service;

import com.whereu.likelionhackathon.domain.user.dto.UserDTO;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
@DisplayName("유저 데이터 조회 테스트")
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void userCheck() {
        UserDTO user1 = UserDTO.builder()
                .uid("1111")
                .name("박주영").build();

        UserDTO checkedUser1 = userService.check(user1);

        log.info(checkedUser1.getUid());
        log.info(checkedUser1.getName());

        log.info("/*-----------------------------------------------*/");

        // DB에 이미 있을경우 uid만 주어져도 전체 데이터 반환.
        UserDTO user2 = UserDTO.builder()
                .uid("1111").build();

        UserDTO checkedUser2 = userService.check(user2);

        log.info(checkedUser2.getUid());
        log.info(checkedUser2.getName());
    }
}