package com.whereu.likelionhackathon.domain.shelter.service;

import com.whereu.likelionhackathon.domain.guide.dto.GuideDTO;
import com.whereu.likelionhackathon.domain.shelter.entity.Shelter;
import com.whereu.likelionhackathon.domain.shelter.entity.ShelterDTO;
import com.whereu.likelionhackathon.domain.shelter.repository.ShelterRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShelterService {

    private final ShelterRepository shelterRepository;
    private final ModelMapper modelMapper;

    public List<ShelterDTO> findShelter(double lat, double lon) {
        List<Shelter> sheltersWithin = shelterRepository.findSheltersWithin(lat, lon, 10);
        return sheltersWithin.stream().map(m->modelMapper.map(m, ShelterDTO.class)).collect(Collectors.toList());
    }
}
