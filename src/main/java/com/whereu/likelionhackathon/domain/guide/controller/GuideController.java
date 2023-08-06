package com.whereu.likelionhackathon.domain.guide.controller;

import com.whereu.likelionhackathon.domain.guide.dto.GuideDTO;
import com.whereu.likelionhackathon.domain.guide.service.GuideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/guide")
@RequiredArgsConstructor
@Log4j2
public class GuideController {
    private final GuideService guideService;

    @GetMapping()
    public List<GuideDTO> guideFindAll() {
        log.info(guideService.findAll());
        return guideService.findAll();
    }

    @GetMapping("/{gid}")
    public GuideDTO guidFindById(@PathVariable(name = "gid") Long gid) {
        return guideService.findById(gid);
    }
}
