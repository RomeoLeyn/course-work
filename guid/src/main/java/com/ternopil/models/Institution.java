package com.ternopil.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ternopil.models.enums.Features;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE/*, generator = "institution_seq"*/)
//    @SequenceGenerator(name = "institution_seq", sequenceName = "institution_seq", allocationSize = 1)
    private Long ID;

    @OneToMany(mappedBy = "institution")
    private List<Photo> photo;

    @Column(name = "description")
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "features")
    @Enumerated(EnumType.STRING)
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
    @Enumerated(EnumType.STRING)
    private InstitutionType typeInstitution;

    @Column(name = "kitchen_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private KitchensType typeKitchens;

    @OneToMany(mappedBy = "institution")
    @JsonIgnore
    private List<Comment> comments;

    @Column(name = "city")
    private String city;

//    @ManyToOne
//    @JoinColumn(name = "country_id")
//    private Country country;
//
//    @ManyToOne
//    @JoinColumn(name = "city_id")
//    private City city;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<WorkingDays> workingDays;
}