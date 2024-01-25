package com.ternopil.repository;

import com.ternopil.models.Institution;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    Page<Institution> getInstitutionByTypeKitchens(KitchensType typeKitchens, PageRequest pageRequest);
    Page<Institution> getInstitutionByTypeInstitution(InstitutionType institutionType, PageRequest pageRequest);
    Page<Institution> findByTypeInstitutionAndTypeKitchensAndCity(InstitutionType institutionType, KitchensType kitchensType, String city, PageRequest pageRequest);
    Page<Institution> getInstitutionByCity(String city, PageRequest pageRequest);
}