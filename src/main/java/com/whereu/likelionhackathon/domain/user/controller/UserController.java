package com.whereu.likelionhackathon.domain.user.controller;


import com.whereu.likelionhackathon.domain.user.dto.UserDTO;
import com.whereu.likelionhackathon.domain.user.entity.User;
import com.whereu.likelionhackathon.domain.user.repository.UserRepository;
import com.whereu.likelionhackathon.domain.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/check")
    public UserDTO userCheck(@RequestBody UserDTO userDTO) {
        UserDTO dto = userService.check(userDTO);

        if (dto != null) return dto;
        else return null;
    }
}
