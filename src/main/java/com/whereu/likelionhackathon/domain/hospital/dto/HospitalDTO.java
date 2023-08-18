package com.whereu.likelionhackathon.domain.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDTO {
    private Long hid;
    private String name; // 병원 이름
    private String phone; // 전화번호
    private String addr; // 주소
    private String type; // 병원종류 (상급종합병원, 종합병원, 병원, 의원, 보건소 등등)
    private Float latit; // 위도
    private Float longit; // 경도
}
