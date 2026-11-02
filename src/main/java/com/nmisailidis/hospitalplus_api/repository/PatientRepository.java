package com.nmisailidis.hospitalplus_api.repository;

import com.nmisailidis.hospitalplus_api.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByAmka(String amka);
}
