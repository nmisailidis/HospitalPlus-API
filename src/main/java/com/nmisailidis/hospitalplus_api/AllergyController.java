package com.nmisailidis.hospitalplus_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospitalPlus/allergies/")
public class AllergyController {

    private final AllergyService allergyService;

    public AllergyController(AllergyService allergyService) {
        this.allergyService = allergyService;
    }

    @GetMapping()
    public List<Allergy> getAllAllergies() {
        return allergyService.getAllAllergies();
    }

    @GetMapping("/{id}")
    public Optional<Allergy> getAllergy(@PathVariable int id) {
        return allergyService.getAllergy(id);
    }




}
