package com.whereu.likelionhackathon.domain.hospital.service;

import com.whereu.likelionhackathon.domain.hospital.dto.HospitalDTO;
import com.whereu.likelionhackathon.domain.hospital.repository.HospitalRepository;
import com.whereu.likelionhackathon.domain.weather.dto.WeatherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final RestTemplate restTemplate;

    @Value("${hospital-api}")
    private String url;

    // lat = 위도
    // long = 경도

    public ResponseEntity<String> findHospital(Float latit, Float longit) {
        List<HospitalDTO> arrayList = new ArrayList<>();

        ResponseEntity<String> data =  restTemplate.getForEntity(URI.create(url + "&xPos=" + latit +
                "&yPos=" + longit + "&radius=3000"), String.class);

        JSONObject jsonObject = new JSONObject(data.getBody());

        JSONObject json_response = jsonObject.getJSONObject("response");

        if (json_response.isNull("body")) {
            return null;
        }

        JSONObject body = json_response.getJSONObject("body");
        JSONObject items = body.getJSONObject("items");
        JSONArray itemArray = items.getJSONArray("item");

        for (int i = 0; i < itemArray.length(); i++) {
            JSONObject obj = itemArray.getJSONObject(i);

            HospitalDTO dto = toDTO(obj);
            arrayList.add(dto);
        }

        return data;
    }

    public List<HospitalDTO> findname(String keyword) throws UnsupportedEncodingException {
        List<HospitalDTO> arrayList = new ArrayList<>();

        String encodedString = URLEncoder.encode(keyword, "UTF-8");

        System.out.println(encodedString);

        ResponseEntity<String> data =  restTemplate.getForEntity(URI.create(url+"&yadmNm=" + encodedString), String.class);

        JSONObject jsonObject = new JSONObject(data.getBody());

        JSONObject json_response = jsonObject.getJSONObject("response");

        if (json_response.isNull("body")) {
            return null;
        }

        JSONObject body = json_response.getJSONObject("body");
        JSONObject items = body.getJSONObject("items");
        JSONArray itemArray = items.getJSONArray("item");

        for (int i = 0; i < itemArray.length(); i++) {
            JSONObject obj = itemArray.getJSONObject(i);

            HospitalDTO dto = toDTO(obj);
            arrayList.add(dto);
        }

        return arrayList;
    }

    public List<HospitalDTO> finddiv(String keyword) throws UnsupportedEncodingException {
        List<HospitalDTO> arrayList = new ArrayList<>();

        String encodedString = URLEncoder.encode(keyword, "UTF-8");

        System.out.println(encodedString);

        ResponseEntity<String> data =  restTemplate.getForEntity(URI.create(url+"&yadmNm=" + encodedString), String.class);

        JSONObject jsonObject = new JSONObject(data.getBody());

        JSONObject json_response = jsonObject.getJSONObject("response");

        if (json_response.isNull("body")) {
            return null;
        }

        JSONObject body = json_response.getJSONObject("body");
        JSONObject items = body.getJSONObject("items");
        JSONArray itemArray = items.getJSONArray("item");

        for (int i = 0; i < itemArray.length(); i++) {
            JSONObject obj = itemArray.getJSONObject(i);

            HospitalDTO dto = toDTO(obj);
            arrayList.add(dto);
        }

        return arrayList;
    }

    private HospitalDTO toDTO(JSONObject obj) {
        return HospitalDTO.builder()
                .name(obj.getString("yadmNm"))
                .addr(obj.getString("addr"))
                .type(obj.getString("clCdNm"))
                .latit(obj.getFloat("XPos"))
                .longit(obj.getFloat("YPos"))
                .phone(obj.getString("telno"))
                .build();
    }
}
