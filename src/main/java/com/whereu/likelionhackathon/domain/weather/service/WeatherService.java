package com.whereu.likelionhackathon.domain.weather.service;

import com.whereu.likelionhackathon.domain.weather.dto.LocationDTO;
import com.whereu.likelionhackathon.domain.weather.dto.WeatherDTO;
import com.whereu.likelionhackathon.domain.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    @Value("${api-url}")
    private String API_URL;

    @Cacheable(value = "weatherData", key = "#choice", unless = "#result == null")
    public List<WeatherDTO> fetchData(int choice) {

        String tempURL = API_URL + choice;
        ResponseEntity<String> response = callApi(tempURL);
        List<WeatherDTO> weatherDTOList = processResponse(response);

        return weatherDTOList;
    }

    private ResponseEntity<String> callApi(String url) {
        log.info("API_URL = {}", url);
        return restTemplate.getForEntity(URI.create(url), String.class);
    }

    private List<WeatherDTO> processResponse(ResponseEntity<String> response) {
        List<WeatherDTO> weatherDTOList = new ArrayList<>();

        if (response.getStatusCode().is2xxSuccessful()) {
            JSONObject jsonObject = new JSONObject(response.getBody());
            weatherDTOList = parseJson(jsonObject);
        } else {
            handleError(response.getStatusCode());
        }

        return weatherDTOList;
    }

    private List<WeatherDTO> parseJson(JSONObject jsonObject) {
        List<WeatherDTO> weatherDTOList = new ArrayList<>();
        JSONObject json_response = jsonObject.getJSONObject("response");

        if (json_response.isNull("body")) {
            return weatherDTOList;
        }

        JSONObject body = json_response.getJSONObject("body");
        JSONObject items = body.getJSONObject("items");
        JSONArray itemArray = items.getJSONArray("item");

        for (int i = 0; i < itemArray.length(); i++) {
            JSONObject obj = itemArray.getJSONObject(i);

            String areaCode = obj.getString("areaCode");

            List<LocationDTO> locationByAreaCode = weatherRepository.findLocationByAreaCode(areaCode);
            System.out.println(locationByAreaCode.size());
            LocationDTO locationDTO = locationByAreaCode.get(0);

            WeatherDTO weatherDTO = createWeatherDTO(locationDTO, obj);
            weatherDTOList.add(weatherDTO);
        }

        return weatherDTOList;
    }

    private void handleError(HttpStatus statusCode) {
        log.error("Error while fetching data from API: " + statusCode);
    }

    private WeatherDTO createWeatherDTO(LocationDTO location, JSONObject obj) {
        return WeatherDTO.builder()
                .lat(location.getLat())
                .lon(location.getLon())
                .warnVar(obj.getInt("warnVar"))
                .warnStress(obj.getInt("warnStress"))
                .areaName(obj.getString("areaName")).build();
    }
}
