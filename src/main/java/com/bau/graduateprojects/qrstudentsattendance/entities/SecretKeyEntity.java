package com.bau.graduateprojects.qrstudentsattendance.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SECRET")
public class SecretKeyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long courseId;
    private String key;
}
