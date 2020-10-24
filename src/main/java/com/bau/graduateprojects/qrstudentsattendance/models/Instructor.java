package com.bau.graduateprojects.qrstudentsattendance.models;

import com.bau.graduateprojects.qrstudentsattendance.enums.WeekDays;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    private String phone;
    private String email;
    private String officeLocation;
    @NotNull
    private LocalTime officeHoursFrom;
    @NotNull
    private LocalTime officeHoursTo;
    @NotNull
    private WeekDays officeHoursWeekDays;
}
