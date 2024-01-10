//package com.ternopil.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//@Entity
//@Getter @Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "city")
//public class City {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE/*, generator = "city_seq"*/)
////    @SequenceGenerator(name = "city_seq", sequenceName = "city_seq", allocationSize = 1)
//    private Long ID;
//
//    @Column(name = "name", unique = true, nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "country_id")
//    private Country country;
//
////    @OneToOne
////    @JoinColumn(name = "institution_id")
////    private Institution institution;
//
//}