package com.bau.graduateprojects.qrstudentsattendance.entities;

import com.bau.graduateprojects.qrstudentsattendance.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ATTENDANCE")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Status status;
    @OneToOne
    private StudentEntity student;
    @ManyToOne
    private LectureEntity lecture;
}
