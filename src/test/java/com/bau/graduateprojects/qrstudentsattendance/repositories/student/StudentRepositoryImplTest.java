package com.bau.graduateprojects.qrstudentsattendance.repositories.student;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryImplTest {

    private MockStudentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MockStudentRepository();
    }

    @Test
    void list() {
        List<StudentEntity> list = repository.list();
        assertTrue(list.isEmpty());
        repository.insert(new StudentEntity());
        assertEquals(1, list.size());
        assertNotNull(list);
    }

    @Test
    void getByUsername() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setUsername("abusalah");
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> repository.getByUsername("abusalah"));
        assertEquals("student not found with username = abusalah", exception.getMessage());
        repository.insert(studentEntity);
        StudentEntity entity = repository.getByUsername("abusalah");
        assertNotNull(entity);
        assertEquals(entity.getUsername(), studentEntity.getUsername());
    }

    @Test
    void insert() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1L);
        studentEntity.setName("abusalah");
        studentEntity.setUsername("username");
        StudentEntity insert = repository.insert(studentEntity);
        assertEquals(insert.getId(), studentEntity.getId());
        assertEquals(insert.getName(), studentEntity.getName());
        assertEquals(insert.getUsername(), studentEntity.getUsername());
    }

    @Test
    void getById() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1L);
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> repository.getById(1L));
        assertEquals("student not found with id = 1", exception.getMessage());
        repository.insert(studentEntity);
        StudentEntity entity = repository.getById(1L);
        assertNotNull(entity);
        assertEquals(entity.getId(), studentEntity.getId());
    }

    @Test
    void update() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1L);
        studentEntity.setPassword("hi");
        StudentEntity update = repository.update(studentEntity);
        assertNotEquals(update, studentEntity);
    }

    @Test
    void removeById() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1L);
        repository.insert(studentEntity);
        assertFalse(repository.list().isEmpty());
        repository.removeById(1L);
        assertTrue(repository.list().isEmpty());
    }

    @Test
    void getCount() {
        repository.insert(new StudentEntity());
        assertEquals(1, repository.getCount());
        repository.insert(new StudentEntity());
        assertEquals(2, repository.getCount());
        repository.insert(new StudentEntity());
        assertEquals(3, repository.getCount());
        repository.insert(new StudentEntity());
        assertEquals(4, repository.getCount());
    }

    @Test
    void existById() {
        assertFalse(repository.existById(1L));
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1L);
        repository.insert(studentEntity);
        assertTrue(repository.existById(1L));
    }
}
