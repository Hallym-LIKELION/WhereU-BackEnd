package com.whereu.likelionhackathon.domain.weather.service;

import com.whereu.likelionhackathon.domain.weather.dto.WeatherDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class WeatherServiceTest {

    @Autowired
    WeatherService weatherService;

    @Test
    public void 경보값검색_테스트() {
        //1-강풍, 2-호우, 3-한파, 4-건조, 5-폭풍해일, 6-풍랑, 7-태풍, 8-대설,9-황사, 12-폭염
        int choice = 1;
        List<WeatherDTO> weatherDTOList = weatherService.fetchData(choice);
        System.out.println(weatherDTOList.size());
    }

}