package com.whereu.likelionhackathon.domain.weather.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility =  JsonAutoDetect.Visibility.ANY)
public class LocationDTO {
    private double lat; //위도
    private double lon; //경도
}
