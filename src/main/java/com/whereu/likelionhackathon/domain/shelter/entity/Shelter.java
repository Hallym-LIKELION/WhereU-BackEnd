package com.whereu.likelionhackathon.domain.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    private String areaName; //지역명
    private double lat; //위도
    private double lon; //경도

    public Shelter(String areaName, double lat, double lon) {
        this.areaName = areaName;
        this.lat = lat;
        this.lon = lon;
    }
}
