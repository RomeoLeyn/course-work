package com.ternopil.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "institution_photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "institution_photo_id_seq")
    @SequenceGenerator(name = "institution_photo_id_seq", sequenceName = "institution_photo_id_seq", allocationSize = 1)
    private Long ID;

    @Column(name = "name_image")
    private String nameImage;

    @ManyToOne
    @JoinColumn(name = "photo")
    private Institution institution;
}