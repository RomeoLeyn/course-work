package com.ternopil.DTO;


import com.ternopil.models.Comment;
import com.ternopil.models.WorkingDays;
import com.ternopil.models.enums.Features;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;

import lombok.Data;

import java.util.List;


@Data
public class InstitutionDTO {

//    private List<Photo> photo;

    private String description;

    private String name;

    private String address;

    private Features features;

    private String socialNetworks;

    private String webSite;

    private double lat;

    private double lon;

    private InstitutionType typeInstitution;

    private KitchensType typeKitchens;

    private String city;

    private List<Comment> comments;

    private List<WorkingDays> workingDays;

}