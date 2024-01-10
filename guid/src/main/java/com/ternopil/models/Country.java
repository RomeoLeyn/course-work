//package com.ternopil.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Table(name = "country")
//public class Country {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE/*, generator = "country_seq"*/)
////    @SequenceGenerator(name = "country_seq", sequenceName = "country_seq", allocationSize = 1)
//    private Long ID;
//
//    @Column(name = "country_name", unique = true, nullable = false)
//    private String name;
//
//    @OneToMany(mappedBy = "country")
//    private List<City> city;
//
////    @OneToMany(mappedBy = "country", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
////    private List<Institution> institution;
//}
//
