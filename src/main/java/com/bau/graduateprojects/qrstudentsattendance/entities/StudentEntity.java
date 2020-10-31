package com.bau.graduateprojects.qrstudentsattendance.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "STUDENT")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String username;
    @OneToMany
    private List<CourseEntity> courseList;
}
