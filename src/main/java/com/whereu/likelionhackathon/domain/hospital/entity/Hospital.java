package com.whereu.likelionhackathon.domain.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hid;
    private String name; // 병원 이름
    private String phone; // 전화번호
    private String addr; // 주소
    private String type; // 병원종류 (상급종합병원, 종합병원, 병원, 의원, 보건소 등등)
    private Float latit; // 위도
    private Float longit; // 경도
}
