package com.whereu.likelionhackathon.domain.weather.repository;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.whereu.likelionhackathon.domain.weather.entity.Weather;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class WeatherRepositoryTest {
    @Autowired
    WeatherRepository weatherRepository;

    @Test
    public void insertCSV() {
        String fileName = "src/main/resources/weather.csv";

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName, StandardCharsets.UTF_8)).withSkipLines(1).build()) {
            String[] line;

            while ((line = csvReader.readNext()) != null) {
                double lon = Double.parseDouble(line[0]);
                double lat = Double.parseDouble(line[1]);
                String areaCode = line[2];
                String areaName = line[3];

                Weather weather = new Weather(lon, lat, areaCode, areaName);
                weatherRepository.save(weather);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}