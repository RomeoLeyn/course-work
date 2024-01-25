package com.ternopil.DTO;

import com.ternopil.models.Institution;
import com.ternopil.models.enums.Days;
import lombok.Data;

import java.sql.Time;

@Data
public class WorkingDaysDTO {

    private Days workingDays;

    private Time startWorkTime;

    private Time endWorkTime;

    private Institution institution;
}
