package com.ternopil.DTO;

import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import lombok.Data;

@Data
public class CommentInstitutionDTO {
    private Long ID;

    private String name;

    private InstitutionType typeInstitution;

    private KitchensType typeKitchens;

    private String city;
}