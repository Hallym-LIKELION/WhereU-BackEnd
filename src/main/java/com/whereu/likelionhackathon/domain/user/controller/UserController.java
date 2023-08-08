package com.whereu.likelionhackathon.domain.user.controller;


import com.whereu.likelionhackathon.domain.user.dto.UserDTO;
import com.whereu.likelionhackathon.domain.user.entity.User;
import com.whereu.likelionhackathon.domain.user.repository.UserRepository;
import com.whereu.likelionhackathon.domain.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping("/check")
    public UserDTO userCheck(UserDTO userDTO) {
        UserDTO dto = userService.check(userDTO);

        if (dto != null) return dto;
        else return null;
    }
}
