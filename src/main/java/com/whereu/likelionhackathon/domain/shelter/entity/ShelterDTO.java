package com.whereu.likelionhackathon.domain.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShelterDTO {
    private String areaName; //지역명
    private double lat; //위도
    private double lon; //경도
}
