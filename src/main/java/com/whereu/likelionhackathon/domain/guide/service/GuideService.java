package com.whereu.likelionhackathon.domain.guide.service;

import com.whereu.likelionhackathon.domain.guide.dto.GuideDTO;

import java.util.List;

public interface GuideService {
    List<GuideDTO> findAll();
}
