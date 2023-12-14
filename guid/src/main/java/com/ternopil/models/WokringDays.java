package com.ternopil.models;

import com.ternopil.models.enums.Days;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Setter @Getter
@Table(name = "working_days")
public class WokringDays {
    @Id
    @GeneratedValue
    private Long ID;

    @Column(name = "work_days")
    private Days days;

    @Column(name = "work_time")
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
}