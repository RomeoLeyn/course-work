package com.ternopil.DTO;

import com.ternopil.models.enums.Features;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import lombok.Data;

@Data
public class InstitutionSummaryDTO {
    private Long ID;

//    private List<Photo> photo;

    private String name;

    private String address;

    private Features features;

    private InstitutionType typeInstitution;

    private KitchensType typeKitchens;

    private String city;
}
