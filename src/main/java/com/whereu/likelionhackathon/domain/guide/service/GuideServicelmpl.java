package com.whereu.likelionhackathon.domain.guide.service;

import com.whereu.likelionhackathon.domain.guide.dto.GuideDTO;
import com.whereu.likelionhackathon.domain.guide.entity.Guide;
import com.whereu.likelionhackathon.domain.guide.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuideServicelmpl implements GuideService{
    private final GuideRepository guideRepository;

    @Override
    public List<GuideDTO> findAll() {
        List<Guide> guideList = guideRepository.findAll();
        return guideList.stream().map(this::toDto).collect(Collectors.toList());
    }

    private GuideDTO toDto(Guide guide) {
        return GuideDTO.builder()
                .gid(guide.getGid())
                .title(guide.getTitle())
                .content(guide.getContent())
                .keyword(guide.getKeyword())
                .build();
    }
}
