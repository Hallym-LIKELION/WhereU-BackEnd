package com.whereu.likelionhackathon.domain.shelter.repository;

import com.whereu.likelionhackathon.domain.shelter.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    @Query(value = "SELECT * FROM shelter s WHERE (6371 * acos(cos(radians(:latitude)) * cos(radians(s.lat)) " +
            "* cos(radians(s.lon) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(s.lat))))" +
            " < :distance", nativeQuery = true)
    List<Shelter> findSheltersWithin(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("distance") double distance);

//    @Query("SELECT s FROM Shelter s WHERE " +
//            "6371 * 2 * ASIN(SQRT(POWER(SIN((s.lat - :lat) * pi() / 180 / 2), 2) + " +
//            "COS(s.lat * pi() / 180) * COS(:lat * pi() / 180) * " +
//            "POWER(SIN((s.lon - :lon) * pi() / 180 / 2), 2))) <= 50")
//    List<Shelter> findSheltersWithin10Km(@Param("lat") double lat, @Param("lon") double lon);

}
