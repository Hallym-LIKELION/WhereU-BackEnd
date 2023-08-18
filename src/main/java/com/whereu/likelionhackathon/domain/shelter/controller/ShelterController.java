package com.whereu.likelionhackathon.domain.shelter.controller;

import com.whereu.likelionhackathon.domain.shelter.entity.ShelterDTO;
import com.whereu.likelionhackathon.domain.shelter.service.ShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/shelter")
@RequiredArgsConstructor
public class ShelterController {

    private final ShelterService shelterService;

    /**
     * @param lat 위도
     * @param lon 경도
     * @return 근방 10km에 있는 대피소 리스트 반환
     */
    @GetMapping()
    public List<ShelterDTO> fetchShelterDTO(@RequestParam(value = "lat") double lat,
                                                     @RequestParam(value = "lon") double lon) {
        List<ShelterDTO> shelter = shelterService.findShelter(lat, lon);
        return shelter;
    }

}
