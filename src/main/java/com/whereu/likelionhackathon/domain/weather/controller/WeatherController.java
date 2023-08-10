package com.whereu.likelionhackathon.domain.weather.controller;

import com.whereu.likelionhackathon.domain.weather.dto.WeatherDTO;
import com.whereu.likelionhackathon.domain.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("{choice}")
    public List<WeatherDTO> fetchWeatherDTO(@PathVariable(name = "choice") int choice) {
        List<WeatherDTO> weatherDTOList = weatherService.fetchData(choice);
        return weatherDTOList;
    }
}
