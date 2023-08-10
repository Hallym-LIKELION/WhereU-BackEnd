package com.whereu.likelionhackathon.domain.weather.repository;

import com.whereu.likelionhackathon.domain.weather.dto.LocationDTO;
import com.whereu.likelionhackathon.domain.weather.entity.Weather;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    @Query(value = "SELECT new com.whereu.likelionhackathon.domain.weather.dto.LocationDTO(w.lat, w.lon)" +
            "from Weather w " +
            "WHERE w.areaCode = :areaCode")
    List<LocationDTO> findLocationByAreaCode(String areaCode);
}
