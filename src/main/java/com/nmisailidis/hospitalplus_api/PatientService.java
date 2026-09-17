package com.nmisailidis.hospitalplus_api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.util.ClassUtils.ifPresent;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService (PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //creates a patient and adds it in the database
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    //calls database to return all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    //searches a patient with its nationalId
    public Patient searchPatient(Patient patient) {

        String nationalId = patient.getNationalId();
        return patientRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new RuntimeException("The patient does not exist"));
    }

    public Patient searchPatient(Long id) {

        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

    }

    //Hospital Management Systems never delete a patient, they deactivate them
    public void deactivatePatient(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        patient.setActiveStatus(false);
        patientRepository.save(patient);
    }



    public Patient updatePatient(Long id, PatientUpdateRequest request) {

        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not dound with id: " + id));


        if (request.getFirstName() != null) {
            existingPatient.setFirstName(request.getFirstName());
        }

        if (request.getLastName() != null) {
            existingPatient.setLastName(request.getLastName());
        }

        if (request.getDateOfBirth() != null) {
            existingPatient.setDateOfBirth(request.getDateOfBirth());
        }

        if (request.getGender() != null) {
            existingPatient.setGender(request.getGender());
        }

        if (request.getAddress() != null) {
            existingPatient.setAddress(request.getAddress());
        }

        if (request.getEmergencyContactName() != null) {
            existingPatient.setEmergencyContactName(request.getEmergencyContactName());
        }

        if (request.getEmergencyContactPhone() != null) {
            existingPatient.setEmergencyContactPhone(request.getEmergencyContactPhone());
        }

        if (request.getBloodGroup() != null) {
            existingPatient.setBloodGroup(request.getBloodGroup());
        }

        return patientRepository.save(existingPatient);

    }


}
