package com.ternopil.models;

import com.ternopil.models.enums.Features;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", unique = true, nullable = false)
    private int phoneNumber;

    @Column(name = "features")
    private Features features;

    @Column(name = "social_networks")
    private String socialNetworks;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "lat")
    private double lat;

    @Column(name = "long")
    private double lon;

    @Column(name = "institution_type", nullable = false)
    private InstitutionType typeInstitution;

    @Column(name = "kitchen_type", nullable = false)
    private KitchensType typeKitchens;

    @OneToMany(mappedBy = "institution")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "institution")
    private List<City> city;

    @OneToMany(mappedBy = "institution")
    private List<WorkingDays> workingDays;
}