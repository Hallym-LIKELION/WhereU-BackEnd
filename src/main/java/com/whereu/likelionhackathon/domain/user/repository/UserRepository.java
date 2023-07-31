package com.whereu.likelionhackathon.domain.user.repository;

import com.whereu.likelionhackathon.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
