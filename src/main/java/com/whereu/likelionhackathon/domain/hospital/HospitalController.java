package com.whereu.likelionhackathon.domain.hospital;

import com.whereu.likelionhackathon.domain.hospital.dto.HospitalDTO;
import com.whereu.likelionhackathon.domain.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/hospital")
@RequiredArgsConstructor
@Log4j2
public class HospitalController {
    private final HospitalService hospitalService;

    // lat = 위도
    // lon = 경도

    //@RequestParam(name = "lat") float latit, @RequestParam(name = "long") float longit

    @GetMapping()
    public List<HospitalDTO> guideFindAll(@RequestParam(name = "lat") float lat, @RequestParam(name = "lon") float lon) {
        List<HospitalDTO> list = hospitalService.findHospital(lat, lon);
        if (list == null) log.error("정보가 없습니다.");
        return list;
    }
}
