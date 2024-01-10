package com.ternopil.mappers;

import com.ternopil.DTO.InstitutionDTO;
import com.ternopil.models.Institution;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstitutionMapper {
    InstitutionMapper INSTANCE = Mappers.getMapper(InstitutionMapper.class);

    InstitutionDTO toDTO(Institution institution);

    Institution toModel(InstitutionDTO institutionDTO);
}
