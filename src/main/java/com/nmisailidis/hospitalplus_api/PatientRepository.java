package com.nmisailidis.hospitalplus_api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByNationalId(String nationalId);
}
