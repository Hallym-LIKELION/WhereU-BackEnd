package com.whereu.likelionhackathon.domain.guide.service;

import com.whereu.likelionhackathon.domain.guide.dto.GuideDTO;
import com.whereu.likelionhackathon.domain.guide.entity.Guide;
import com.whereu.likelionhackathon.domain.guide.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuideServicelmpl implements GuideService{
    private final GuideRepository guideRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<GuideDTO> findAll() {
        List<Guide> guideList = guideRepository.findAll();
        return guideList.stream().map(m->modelMapper.map(m, GuideDTO.class)).collect(Collectors.toList());
    }
}
