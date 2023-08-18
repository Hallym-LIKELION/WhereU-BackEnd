package com.whereu.likelionhackathon.domain;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.whereu.likelionhackathon.domain.guide.entity.Guide;
import com.whereu.likelionhackathon.domain.guide.repository.GuideRepository;
import com.whereu.likelionhackathon.domain.shelter.entity.Shelter;
import com.whereu.likelionhackathon.domain.shelter.repository.ShelterRepository;
import com.whereu.likelionhackathon.domain.weather.entity.Weather;
import com.whereu.likelionhackathon.domain.weather.repository.WeatherRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;

@SpringBootTest
@Slf4j
public class DataInsert {
    @Autowired
    GuideRepository guideRepository;

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    ShelterRepository shelterRepository;

    @Test
    @DisplayName("가이드 내용 저장")
    public void guideSave() {
        String[][] list = {
                {"침수", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent21.html?menuSeq=126"},
                {"태풍", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent02.html?menuSeq=126"},
                {"호우", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent18.html?menuSeq=126"},
                {"낙뢰" ,"https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent03.html?menuSeq=126"},
                {"강풍", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent04.html?menuSeq=126"},
                {"풍랑", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent19.html?menuSeq=126"},
                {"대설", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent05.html?menuSeq=126"},
                {"한파", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent06.html?menuSeq=126"},
                {"폭염", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent07.html?menuSeq=126"},
                {"황사", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent08.html?menuSeq=126"},
                {"지진", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent09.html?menuSeq=126"},
                {"해일", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent10.html?menuSeq=126"},
                {"지진해일", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent16.html?menuSeq=126"},
                {"화산폭발", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent11.html?menuSeq=126"},
                {"가뭄", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent12.html?menuSeq=126"},
                {"홍수", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent13.html?menuSeq=126"},
                {"해수면상승", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent17.html?menuSeq=126"},
                {"산사태", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent20.html?menuSeq=126"},
                {"자연우주물체추락", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent22.html?menuSeq=126"},
                {"우주전파재난", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent23.html?menuSeq=126"},
                {"조류대발생(녹조)", "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent24.html?menuSeq=126"}
        };

        for (int i = 0; i < list.length; i++) {
            Guide guide = Guide.builder().keyword(list[i][0]).url(list[i][1]).build();
            guideRepository.save(guide);
        }

        System.out.println("저장 완료");
    }

    @Test
    public void insertShelter() {
        String fileName = "src/main/resources/shelter.csv";

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName, StandardCharsets.UTF_8)).withSkipLines(1).build()) {
            String[] line;

            while ((line = csvReader.readNext()) != null) {
                double lat = Double.parseDouble(line[1]);
                double lon = Double.parseDouble(line[2]);
                String areaName = line[0];

                Shelter shelter = new Shelter(areaName, lat, lon);
                shelterRepository.save(shelter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void insertWeather() {
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
