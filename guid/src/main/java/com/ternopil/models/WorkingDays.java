package com.ternopil.models;

import com.ternopil.models.enums.Days;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Table(name = "working_days")
public class WorkingDays {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;

    @Column(name = "work_days")
    private Days days;

    @Column(name = "start_work_time")
    private LocalTime startWorkTime;

    @Column(name = "end_work_time")
    private LocalTime endWorkTime;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
}