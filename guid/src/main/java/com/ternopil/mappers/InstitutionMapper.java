package com.ternopil.mappers;

import com.ternopil.DTO.InstitutionDTO;
import com.ternopil.DTO.InstitutionSummaryDTO;
import com.ternopil.DTO.WorkingDaysDTO;
import com.ternopil.models.Institution;
import com.ternopil.models.WorkingDays;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstitutionMapper {
    InstitutionMapper INSTANCE = Mappers.getMapper(InstitutionMapper.class);

    InstitutionDTO toDTO(Institution institution);

    Institution toModel(InstitutionDTO institutionDTO);

    InstitutionSummaryDTO toSummaryDTO(Institution institution);

    WorkingDaysDTO toDTO(WorkingDays workingDays);

    WorkingDays toModel(WorkingDaysDTO workingDaysDTO);
}
