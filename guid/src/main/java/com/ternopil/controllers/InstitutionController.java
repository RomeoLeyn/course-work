package com.ternopil.controllers;

import com.ternopil.models.Institution;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution")
@RequiredArgsConstructor
public class InstitutionController {

    // Show all Institution
    @GetMapping
    public List<Institution> getAllInstitution() {
        return null;
    }

    // Show institution by kitchen-type
    @GetMapping("/{kitchen-type}")
    public List<Institution> getInstitutionByKitchenType(@RequestParam String typeKitchen) {
        return null;
    }

    // Show by type institution
    @GetMapping("/{type}")
    public List<Institution> getInstitutionByType(@RequestParam String type) {
        return null;
    }

    // Show by city
    @GetMapping("/{city}")
    public List<Institution> getInstituitonByCity(@RequestParam String city) {
        return null;
    }

    // Create new institution
    @PostMapping
    public void createNewInstitution(@RequestBody Institution institution) {

    }

    // Update institution
    @PutMapping("/{id}")
    public void updateInstitution(@PathVariable Long ID, @RequestBody Institution institution) {

    }

    // Delete institution
    @DeleteMapping("/{id}")
    public void removeInstitution(@PathVariable Long ID) {

    }
}
