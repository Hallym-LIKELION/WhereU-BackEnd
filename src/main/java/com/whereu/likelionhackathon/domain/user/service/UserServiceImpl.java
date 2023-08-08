package com.whereu.likelionhackathon.domain.user.service;

import com.whereu.likelionhackathon.domain.user.dto.UserDTO;
import com.whereu.likelionhackathon.domain.user.entity.User;
import com.whereu.likelionhackathon.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    /**
     * @param userDTO
     * uid가 DB에 없다면 DB에 저장.
     * uid가 DB에 있다면 DB에서 전체정보 조회 후 반환.
     */
    @Override
    public UserDTO check(UserDTO userDTO) {
        String uid = userDTO.getUid();
        Optional<User> byUid = userRepository.findByUid(uid);
        if (byUid.isPresent()) {
            return modelMapper.map(byUid.get(), UserDTO.class);
        } else {
            User user = modelMapper.map(userDTO, User.class);
            userRepository.save(user);
            return userDTO;
        }
    }
}
