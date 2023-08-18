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
import java.util.Objects;

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

    public List<HospitalDTO> findHospital(Float latit, Float longit) {
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

        return arrayList;
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

    public List<HospitalDTO> finddiv(String clinic) throws UnsupportedEncodingException {
        List<HospitalDTO> arrayList = new ArrayList<>();

        String code = null;

        for (int i = 0; i < listDiv.length; i++) {
            if (Objects.equals(listDiv[i][1], clinic)) {
                code = listDiv[i][0];
                break;
            }
        }

        System.out.println(clinic);
        System.out.println(code);

        ResponseEntity<String> data =  restTemplate.getForEntity(URI.create(url+"&dgsbjtCd=" + code), String.class);

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

            HospitalDTO dto = toDTO1(obj);
            arrayList.add(dto);
        }

        return arrayList;
    }

    String[][] listDiv = { { "00" ,	"일반의" } ,
    { "01" ,	"내과" } ,
    { "02" ,	"신경과" } ,
    { "03" ,	"정신건강의학과" } ,
    { "04" ,	"외과" } ,
    { "05" ,	"정형외과" } ,
    { "06" ,	"신경외과" } ,
    { "07" ,	"심장혈관흉부외과" } ,
    { "08" ,	"성형외과" } ,
    { "09" ,	"마취통증의학과" } ,
    { "10" ,	"산부인과" } ,
    { "11" ,	"소아청소년과" } ,
    { "12" ,	"안과" } ,
    { "13" ,	"이비인후과" } ,
    { "14" ,	"피부과" } ,
    { "15" ,	"비뇨의학과" } ,
    { "16" ,	"진단방사선과,영상의학과" } ,
    { "17" ,	"방사선종양학과" } ,
    { "18" ,	"병리과" } ,
    { "19" ,	"진단검사의학과" } ,
    { "20" ,	"결핵과" } ,
    { "21" ,	"재활의학과" } ,
    { "22" ,	"핵의학과" } ,
    { "23" ,	"가정의학과" } ,
    { "24" ,	"응급의학과" } ,
    { "25" ,	"직업환경의학과" } ,
    { "26" ,	"예방의학과" } ,
    { "27" ,	"치과" } ,
    { "28" ,	"한방" } ,
    { "30" ,	"약국" } ,
    { "31" ,	"기타" } ,
    { "40" ,	"약국" } ,
    { "41" ,	"보건" } ,
    { "42" ,	"보건기관치과" } ,
    { "44" ,	"보건기관한방" } ,
    { "49" ,	"치과" } ,
    { "50" ,	"구강악안면외과" } ,
    { "51" ,	"치과보철과" } ,
    { "52" ,	"치과교정과" } ,
    { "53" ,	"소아치과" } ,
    { "54" ,	"치주과" } ,
    { "55" ,	"치과보존과" } ,
    { "56" ,	"구강내과" } ,
    { "57" ,	"영상치의학과" } ,
    { "58" ,	"구강병리과" } ,
    { "59" ,	"예방치과" } ,
    { "60" ,	"치과소계" } ,
    { "61" ,	"통합치의학과" } ,
    { "80" ,	"한방내과" } ,
    { "81" ,	"한붕부인과" } ,
    { "82" ,	"한방소아과" } ,
    { "83" ,	"한방안이비인인후피부과" } ,
    { "84" ,	"한방신경정신과" } ,
    { "85" ,	"침구과" } ,
    { "86" ,	"한방재활의학과" } ,
    { "87" ,	"사상체질과" } ,
    { "88" ,	"한방응급" } ,
    { "90" ,	"한방소계" } };






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

    private HospitalDTO toDTO1(JSONObject obj) {

        return HospitalDTO.builder()
                .name(obj.getString("yadmNm"))
                .addr(obj.getString("addr"))
                .type(obj.getString("clCdNm"))
                .latit(obj.getFloat("XPos"))
                .longit(obj.getFloat("YPos"))
                .build();
    }
}
