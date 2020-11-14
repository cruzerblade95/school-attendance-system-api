package com.bau.graduateprojects.qrstudentsattendance.entities;

import com.bau.graduateprojects.qrstudentsattendance.enums.Collage;
import com.bau.graduateprojects.qrstudentsattendance.enums.DegreeLevel;
import com.bau.graduateprojects.qrstudentsattendance.enums.Major;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "STUDENT")
public class StudentEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "student name is required")
    private String name;
    @NotBlank(message = "student username is required")
    private String username;
    @NotBlank(message = "student password is required")
    private String password;
    @Enumerated(EnumType.STRING)
    private Collage collage;
    @Enumerated(EnumType.STRING)
    private Major major;
    @Enumerated(EnumType.STRING)
    private DegreeLevel degreeLevel;
    private String nationality;
    private String birthCountry;
    private int successHours;
    private LocalDate birthDate;
    private LocalDateTime creationDate;
    @OneToMany
    private List<CourseEntity> courseList;
    private Long absentNumber;

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDateTime.now();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
