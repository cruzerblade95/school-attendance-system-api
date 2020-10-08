package com.bau.graduateprojects.qrstudentsattendance.models;

import com.bau.graduateprojects.qrstudentsattendance.services.DateTimeService;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String universityId;
    private LocalDate birthDay;
    private int numberOfAbsence;
    private LocalDateTime creationDate;

    @PrePersist
    public void prePersist() {
        this.creationDate = DateTimeService.currentDateTime();
        this.numberOfAbsence = 0;
    }
}
