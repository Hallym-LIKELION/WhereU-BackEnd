package com.whereu.likelionhackathon.domain.user.repository;

import com.whereu.likelionhackathon.domain.user.entity.User;
import org.apache.logging.log4j.LogManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    public void 유저등록() {
        User user1 = User.builder().
                name("박주영").build();
        userRepository.save(user1);

        String username = userRepository.findById(1L).get().getName();
        logger.info("이름 : {}", username);
    }
}