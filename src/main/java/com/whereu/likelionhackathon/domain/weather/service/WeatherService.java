package com.whereu.likelionhackathon.domain.weather.service;

import com.whereu.likelionhackathon.domain.weather.dto.LocationDTO;
import com.whereu.likelionhackathon.domain.weather.dto.WeatherDTO;
import com.whereu.likelionhackathon.domain.weather.entity.Weather;
import com.whereu.likelionhackathon.domain.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    @Value("${api-url}")
    private String API_URL;

    /**
     * 특보 종류를 input으로 받음.
     * 특보 종류로 API 요청.
     * 1-강풍, 2-호우, 3-한파, 4-건조, 5-폭풍해일, 6-풍랑, 7-태풍, 8-대설,9-황사, 12-폭염
     */
    public List<WeatherDTO> fetchData(int choice) {
        String tempURL = API_URL + choice;
        log.info("API_URL = {}", tempURL);
        ResponseEntity<String> response = restTemplate.getForEntity(URI.create(tempURL), String.class);

        List<WeatherDTO> weatherDTOList = new ArrayList<>();

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            JSONObject jsonObject = new JSONObject(responseBody);
            JSONObject json_response = jsonObject.getJSONObject("response");
            if (json_response.isNull("body")) { // 데이터가 없을 때
                return null;
            }
            JSONObject body = json_response.getJSONObject("body");
            JSONObject items = body.getJSONObject("items");
            JSONArray itemArray = items.getJSONArray("item");

            for (int i = 0; i < itemArray.length(); i++) {
                JSONObject obj = itemArray.getJSONObject(i);

                String areaCode = obj.getString("areaCode");
                String areaName = obj.getString("areaName");
                int warnVar = obj.getInt("warnVar");
                int warnStress = obj.getInt("warnStress");

                List<LocationDTO> locationByAreaCode = weatherRepository.findLocationByAreaCode(areaCode);
                LocationDTO locationDTO = locationByAreaCode.get(0); //처음나온 1개만

                WeatherDTO weatherDTO = WeatherDTO.builder().
                        lat(locationDTO.getLat()).
                        lon(locationDTO.getLon()).
                        warnVar(warnVar).
                        warnStress(warnStress).
                        areaName(areaName).build();

                weatherDTOList.add(weatherDTO);
            }
        } else {
            log.error("Error while fetching data from API: " + response.getStatusCode());
        }

        tempURL = API_URL;
        return weatherDTOList;
    }
}
