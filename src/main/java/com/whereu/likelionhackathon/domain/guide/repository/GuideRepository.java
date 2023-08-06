package com.whereu.likelionhackathon.domain.guide.repository;

import com.whereu.likelionhackathon.domain.guide.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {
}
