package com.whereu.likelionhackathon.domain.guide.service;

import com.whereu.likelionhackathon.domain.guide.dto.GuideDTO;
import com.whereu.likelionhackathon.domain.guide.entity.Guide;
import com.whereu.likelionhackathon.domain.guide.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public GuideDTO findById(Long gid) {
        Optional<Guide> guide = guideRepository.findById(gid);
        return modelMapper.map(guide, GuideDTO.class);

    }

    @Override
    public List<GuideDTO> search(String keyword) {
        List<Guide> guideList = guideRepository.findByKeywordContaining(keyword);
        return guideList.stream().map(m->modelMapper.map(m, GuideDTO.class)).collect(Collectors.toList());
    }
}
