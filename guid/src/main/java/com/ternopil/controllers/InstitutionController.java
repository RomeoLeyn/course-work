package com.ternopil.controllers;

import com.ternopil.DTO.InstitutionDTO;
import com.ternopil.models.Institution;
import com.ternopil.models.WorkingDays;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import com.ternopil.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution")
@RequiredArgsConstructor
public class InstitutionController {

    private InstitutionService institutionService;

    @Autowired
    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    // Create new institution
    @PostMapping("/create")
    public ResponseEntity<Institution> createInstitution(@RequestBody InstitutionDTO institutionDTO) {
        institutionService.createInstitution(institutionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/work-days")
    public void addWorkDays(@PathVariable Long id,
                            @RequestParam WorkingDays workingDays) {
        institutionService.workDays(id, workingDays);
    }

    // Show all Institution
    @GetMapping
    public List<InstitutionDTO> getAllInstitution(@RequestParam(required = false, defaultValue = "0") int page,
                                                  @RequestParam(required = false, defaultValue = "10") int size) {
        return institutionService.gettAll(PageRequest.of(page, size, Sort.by("name")));
    }

    // Show institution by kitchen-type
    @GetMapping("/get-by-kitchen-type/{typeKitchens}")
    public List<InstitutionDTO> getInstitutionByKitchenType(@PathVariable KitchensType typeKitchens,
                                                            @RequestParam(required = false, defaultValue = "0") int page,
                                                            @RequestParam(required = false, defaultValue = "10") int size) {
        return institutionService.getByKitchenType(typeKitchens, PageRequest.of(page,size, Sort.by("name")));
    }

    // Show by type institution
    @GetMapping("/get-by/{institutionType}")
    public List<InstitutionDTO> getInstitutionByType(@PathVariable InstitutionType institutionType,
                                                     @RequestParam(required = false, defaultValue = "0") int page,
                                                     @RequestParam(required = false, defaultValue = "10") int size) {
        return institutionService.getByInstitutionType(institutionType, PageRequest.of(page, size, Sort.by("name")));
    }

    // Show by city
    @GetMapping("/{city}")
    public List<InstitutionDTO> getInstituitonByCity(@RequestParam String city) {
        return null;
    }

    @GetMapping("/filter")
    public ResponseEntity<List<InstitutionDTO>> findInstitutionsByFilters(
            @RequestParam(required = false) InstitutionType institutionType,
            @RequestParam(required = false) KitchensType kitchenType,
            @RequestParam(required = false) String city,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        List<InstitutionDTO> foundInstitutions = institutionService.getByFilter(institutionType, kitchenType, city, PageRequest.of(page,size));
        return ResponseEntity.ok(foundInstitutions);
    }

    // Update institution
    @PutMapping("/update/{id}")
    public void updateInstitution(@PathVariable Long id, @RequestBody InstitutionDTO institutionDTO) {
        institutionService.update(id, institutionDTO);
    }

    // Delete institution
    @DeleteMapping("/{id}")
    public void removeInstitution(@PathVariable Long id) {
        institutionService.remove(id);
    }
}