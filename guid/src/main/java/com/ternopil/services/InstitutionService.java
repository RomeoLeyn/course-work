package com.ternopil.services;

import com.ternopil.DTO.InstitutionDTO;
import com.ternopil.DTO.InstitutionSummaryDTO;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface InstitutionService {
    InstitutionDTO createInstitution(InstitutionDTO institutionDTO);

//    void workDays(Long id, WorkingDays workingDays);
    List<InstitutionSummaryDTO> getAll(PageRequest pageRequest);

    InstitutionDTO findById(Long id);

    List<InstitutionSummaryDTO> getByKitchenType(KitchensType typeKitchens, PageRequest pageRequest);

    List<InstitutionSummaryDTO> getByInstitutionType(InstitutionType institutionType, PageRequest pageRequest);

    List<InstitutionDTO> getByFilter(InstitutionType institutionType, KitchensType kitchensType, String city, PageRequest pageRequest);

    List<InstitutionDTO> getByCity(String city, PageRequest pageRequest);

    void update(Long id, InstitutionDTO institutionDTO);

    void remove(Long id);
}