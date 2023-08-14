package com.whereu.likelionhackathon.domain.weather.controller;

import com.whereu.likelionhackathon.domain.weather.dto.WeatherDTO;
import com.whereu.likelionhackathon.domain.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
@RequestMapping("api/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("{choice}")
    public Map<String, List<Object>> fetchWeatherDTO(@PathVariable(name = "choice") int choice) {
        if (!choiceValidation(choice)) {
            List<Object> errorMessage = List.of("유효하지 않은 특보 번호 입니다.");
            return Map.of("result", errorMessage);
        }

        List<WeatherDTO> weatherDTOList = weatherService.fetchData(choice);

        if (weatherDTOList.size() == 0) {
            List<Object> errorMessage = List.of("해당 특보 발령 지역이 없습니다.");
            return Map.of("result", errorMessage);
        } else {
            return Map.of("result", new ArrayList<>(weatherDTOList));
        }

    }

    private boolean choiceValidation(int choice) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12};
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(numbers));
        return numberSet.contains(choice) ? true : false;
    }

}
