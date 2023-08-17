package com.whereu.likelionhackathon.domain.hospital.repository;

import com.whereu.likelionhackathon.domain.hospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
