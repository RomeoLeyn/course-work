package com.ternopil.models;

import jakarta.persistence.*;

@Entity
@Table(name = "institution_photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String nameImage;

    @ManyToOne
    @JoinColumn(name = "photo")
    private Institution institution;
}