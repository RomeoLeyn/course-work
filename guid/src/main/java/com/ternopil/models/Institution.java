package com.ternopil.models;

import com.ternopil.models.enums.Features;
import com.ternopil.models.enums.TypeInstitution;
import com.ternopil.models.enums.TypeKitchens;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;

    @OneToMany(mappedBy = "institution")
    private List<Photo> photo;

    @Column(name = "description")
    String description;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "features")
    private Features features;

    @Column(name = "social_networks")
    private String socialNetworks;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "map")
    private String map;

    @Column(name = "distance")
    private double distance;

    @Column(name = "type_institution")
    private TypeInstitution typeInstitution;

    @Column(name = "type_kitchen")
    private TypeKitchens typeKitchens;

    @OneToMany(mappedBy = "institution")
    private List<Comment> comments;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "institution")
    private List<City> city;

    @OneToMany(mappedBy = "institution")
    private List<WokringDays> wokringDays;
}