package com.whereu.likelionhackathon.domain.shelter.repository;

import com.whereu.likelionhackathon.domain.shelter.entity.Shelter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ShelterRepositoryTest {

    @Autowired
    ShelterRepository shelterRepository;

    @Test
    public void findSheltersWithinRadius() {
        double lat = 37.664156;
        double lon = 127.027737;
        double ladious = 10;

        List<Shelter> sheltersWithinRadius = shelterRepository.findSheltersWithin(lat, lon, ladious);
        System.out.println("size : " + sheltersWithinRadius.size() + "--------------------");
        for (Shelter shelter : sheltersWithinRadius) {
            System.out.println(shelter.getAreaName());
            System.out.println(shelter.getLat());
            System.out.println(shelter.getLon());
            System.out.println("---------------------------------");
        }
    }
}