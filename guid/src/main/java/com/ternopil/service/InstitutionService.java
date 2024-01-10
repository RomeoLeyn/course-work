package com.ternopil.service;

import com.ternopil.DTO.InstitutionDTO;
import com.ternopil.models.WorkingDays;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface InstitutionService {
    void createInstitution(InstitutionDTO institutionDTO);

    void workDays(Long id, WorkingDays workingDays);
    List<InstitutionDTO> gettAll(PageRequest pageRequest);

    List<InstitutionDTO> getByKitchenType(KitchensType typeKitchens, PageRequest pageRequest);

    List<InstitutionDTO> getByInstitutionType(InstitutionType institutionType, PageRequest pageRequest);

    List<InstitutionDTO> getByFilter(InstitutionType institutionType, KitchensType kitchensType, String city, PageRequest pageRequest);

    void update(Long id, InstitutionDTO institutionDTO);

    void remove(Long id);
}