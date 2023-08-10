package com.whereu.likelionhackathon.domain.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wid;
    private String areaCode; //지역코드
    private String areaName; //지역명
    private double lat; //위도
    private double lon; //경도

    public Weather(double lon, double lat, String areaCode, String areaName) {
        this.lon = lon;
        this.lat = lat;
        this.areaCode = areaCode;
        this.areaName = areaName;
    }
}
