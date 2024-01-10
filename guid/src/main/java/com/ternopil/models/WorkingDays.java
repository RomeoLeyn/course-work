package com.ternopil.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ternopil.models.enums.Days;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Table(name = "working_days")
public class WorkingDays {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE/*, generator = "working_days_seq"*/)
//    @SequenceGenerator(name = "working_days_seq", sequenceName = "working_days_seq", allocationSize = 1)
    private Long ID;

    @Column(name = "work_days")
    @Enumerated(EnumType.ORDINAL)
    private Days workingDays;

    @Column(name = "start_work_time")
    private Time startWorkTime;

    @Column(name = "end_work_time")
    private Time endWorkTime;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    @JsonBackReference
    private Institution institution;

}