package com.bau.graduateprojects.qrstudentsattendance.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @OneToMany
    private List<InstructorOfficeHours> instructorOfficeHours;
    @OneToMany
    private List<Course> courses;

    // TODO edit the relations between the entities
}
