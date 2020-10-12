package com.bau.graduateprojects.qrstudentsattendance.models;

import com.bau.graduateprojects.qrstudentsattendance.enums.Semester;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @Enumerated(EnumType.STRING)
    private Semester semester;
    private int sectionNo;
    @ManyToOne
    private Instructor instructor;

}
