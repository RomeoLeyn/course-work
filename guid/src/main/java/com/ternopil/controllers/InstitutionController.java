package com.ternopil.controllers;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.DTO.InstitutionDTO;
import com.ternopil.DTO.InstitutionSummaryDTO;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import com.ternopil.services.CommentService;
import com.ternopil.services.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/institution")
@RequiredArgsConstructor
public class InstitutionController {

    private InstitutionService institutionService;
    private CommentService commentService;

    @Autowired
    public InstitutionController(InstitutionService institutionService, CommentService commentService) {
        this.institutionService = institutionService;
        this.commentService = commentService;
    }

    // Create new institution
    @PostMapping("/create-institution")
    public ResponseEntity<InstitutionDTO> createInstitution(@RequestBody InstitutionDTO institutionDTO) {
        InstitutionDTO institutionDTOSaved = institutionService.createInstitution(institutionDTO);
        var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(institutionDTOSaved.getID()).toUri();
        return ResponseEntity.created(location).body(institutionDTOSaved);
    }

    // Show all Institution
    @GetMapping("/get-all-institution")
    public List<InstitutionSummaryDTO> getAllInstitution(@RequestParam(required = false, defaultValue = "0") int page,
                                                         @RequestParam(required = false, defaultValue = "10") int size) {
        return institutionService.getAll(PageRequest.of(page, size, Sort.by("name")));
    }

    // Show institution by kitchen-type
    @GetMapping("/get-by-kitchen-type")
    public List<InstitutionSummaryDTO> getInstitutionByKitchenType(@RequestParam KitchensType typeKitchens,
                                                            @RequestParam(required = false, defaultValue = "0") int page,
                                                            @RequestParam(required = false, defaultValue = "10") int size) {
        return institutionService.getByKitchenType(typeKitchens, PageRequest.of(page, size, Sort.by("name")));
    }

    // Show by type institution
    @GetMapping("/get-by-institution-type")
    public List<InstitutionSummaryDTO> getInstitutionByType(@RequestParam InstitutionType institutionType,
                                                     @RequestParam(required = false, defaultValue = "0") int page,
                                                     @RequestParam(required = false, defaultValue = "10") int size) {
        return institutionService.getByInstitutionType(institutionType, PageRequest.of(page, size, Sort.by("name")));
    }

    // Show by city
    @GetMapping("/get-by-city")
    public List<InstitutionDTO> getInstitutionByCity(@RequestParam String city,
                                                     @RequestParam(required = false, defaultValue = "0") int page,
                                                     @RequestParam(required = false, defaultValue = "10") int size) {
        return institutionService.getByCity(city, PageRequest.of(page, size));
    }

    @GetMapping("/find-by-id/{id}")
    public InstitutionDTO findById(@PathVariable Long id) {
        return institutionService.findById(id);
    }


    @GetMapping("/sort")
    public ResponseEntity<List<InstitutionDTO>> findInstitutionsByFilters(
            @RequestParam(required = false) InstitutionType institutionType,
            @RequestParam(required = false) KitchensType kitchenType,
            @RequestParam(required = false) String city,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        List<InstitutionDTO> foundInstitutions = institutionService.getByFilter(institutionType, kitchenType, city, PageRequest.of(page, size));
        return ResponseEntity.ok(foundInstitutions);
    }

    // Get all institution comment
    @GetMapping("/{id}/comments")
    public List<CommentDTO> getAllInstitutionComments(@PathVariable Long id,
                                                      @RequestParam(required = false, defaultValue = "0") int page,
                                                      @RequestParam(required = false, defaultValue = "10") int size) {

        return commentService.getAllCommentByInstitutionId(id, PageRequest.of(page, size));
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