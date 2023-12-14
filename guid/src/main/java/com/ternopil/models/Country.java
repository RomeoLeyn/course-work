package com.ternopil.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue
    private Long ID;

    @Column(name = "country_name")
    private String name;

    @OneToMany
    private List<City> city;

    @OneToMany(mappedBy = "country")
    @JoinColumn(name = "institution_id")
    private List<Institution> institution;
}