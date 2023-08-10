package com.whereu.likelionhackathon.domain.weather.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class WeatherDTO {
    private int warnVar;
    private int warnStress;
    private String areaName;
    private double lat; //위도
    private double lon; //경도
}
