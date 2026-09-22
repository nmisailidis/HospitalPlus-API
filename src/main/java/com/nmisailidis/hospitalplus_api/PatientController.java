package com.nmisailidis.hospitalplus_api;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/hospitalPlus/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping()
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient searchPatient(@PathVariable Long id) {
        return patientService.searchPatient(id);
    }

    @GetMapping("/search?amka={amka}")
    public Patient searchPatient(@PathVariable String amka) {
        return patientService.searchPatient(amka);
    }

    @PostMapping()
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody PatientUpdateRequest request) {
        Patient updatedPatient = patientService.updatePatient(id, request);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {

        patientService.deactivatePatient(id);
        return ResponseEntity.ok("Patient with id: " + id + "deactivated successfully");
    }

}

