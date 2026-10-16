package com.nmisailidis.hospitalplus_api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Allergy> createAllergy(@Valid @RequestBody AllergyCreationRequest request) {
        Allergy allergy = allergyService.creatAllergy(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(allergy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Allergy> updateAllergy(@PathVariable int id, @Valid @RequestBody AllergyUpdateRequest request) {
        Allergy updateAllergy = allergyService.updateAllergy(id, request);
        return ResponseEntity.ok(updateAllergy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAllergy(@PathVariable int id) {
        allergyService.deleteAllergy(id);
        return ResponseEntity.ok("Allergy with id: " + id + " deleted successfully");
    }

}
