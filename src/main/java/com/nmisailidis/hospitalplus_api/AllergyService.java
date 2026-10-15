package com.nmisailidis.hospitalplus_api;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllergyService {

    private final AllergyRepository allergyRepository;

    public AllergyService(AllergyRepository allergyRepository) {
        this.allergyRepository = allergyRepository;
    }

    public Allergy creatAllergy(AllergyCreationRequest request) {
        Allergy allergy = new Allergy();
        allergy.setAllergyName(request.getAllergyName());
        return allergyRepository.save(allergy);
    }

    //returns all the patients with a specific allergy
    public Optional<Allergy> getAllergy(int id) {
        return allergyRepository.findById(id);
    }

    public List<Allergy> getAllAllergies() {
        return allergyRepository.findAll();
    }

    public Allergy updateAllergy(int id, AllergyUpdateRequest request) {
        Allergy existingAllergy = allergyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allergy not found"));

        if (request.getAllergyName() != null) {
            existingAllergy.setAllergyName(request.getAllergyName());
        }

        return allergyRepository.save(existingAllergy);
    }

    public void deleteAllergy(int id) {
        Allergy existingAllergy = allergyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allergy not found"));

        allergyRepository.delete(existingAllergy);
    }



}
