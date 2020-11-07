//package com.bau.graduateprojects.qrstudentsattendance.repositories.student;
//
//import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//public class StudentRepositoryImplTest {
//
//    private SpringJpaStudentRepository jpaRepository;
//    private StudentRepository repository;
//
//    @BeforeEach
//    void setUp() {
//        jpaRepository = Mockito.mock(SpringJpaStudentRepository.class);
//        repository = new StudentRepositoryImpl(jpaRepository);
//    }
//
//    @Test
//    void givenValidStudentEntityWhenAddNewStudentThenSave() {
//        StudentEntity entity = new StudentEntity();
//        entity.setName("name");
//        entity.setPassword("password");
//        entity.setUsername("username");
//        when(jpaRepository.save(any(StudentEntity.class))).thenReturn(entity);
//
//        StudentEntity actual = jpaRepository.save(entity);
//        assertEquals(entity, actual);
//    }
//}
