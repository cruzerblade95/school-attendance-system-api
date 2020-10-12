package com.bau.graduateprojects.qrstudentsattendance.models;

import com.bau.graduateprojects.qrstudentsattendance.enums.WeekDays;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
@Entity
public class InstructorOfficeHours {
    @Id
    private Long id;
    @NotNull
    private LocalTime from;
    @NotNull
    private LocalTime to;
    @NotNull
    private WeekDays weekDays;
}
