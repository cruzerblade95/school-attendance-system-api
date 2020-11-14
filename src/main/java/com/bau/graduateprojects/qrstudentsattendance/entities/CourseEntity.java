package com.bau.graduateprojects.qrstudentsattendance.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "COURSE")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "name is required")
    private String name;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher_id;
    @OneToMany
    private List<LectureEntity> lectureList;
}
