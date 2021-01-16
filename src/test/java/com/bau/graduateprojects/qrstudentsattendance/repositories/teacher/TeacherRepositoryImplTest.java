package com.bau.graduateprojects.qrstudentsattendance.repositories.teacher;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherRepositoryImplTest {

    private MockTeacherRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MockTeacherRepository();
    }

    @Test
    void list() {
        List<TeacherEntity> list = repository.list();
        assertTrue(list.isEmpty());
        repository.insert(new TeacherEntity());
        assertEquals(1, list.size());
        assertNotNull(list);
    }

    @Test
    void insert() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1L);
        teacherEntity.setName("abusalah");
        teacherEntity.setUsername("username");
        TeacherEntity insert = repository.insert(teacherEntity);
        assertEquals(insert.getId(), teacherEntity.getId());
        assertEquals(insert.getName(), teacherEntity.getName());
        assertEquals(insert.getUsername(), teacherEntity.getUsername());
    }

    @Test
    void getById() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1L);
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> repository.getById(1L));
        assertEquals("teacher not found with id = 1", exception.getMessage());
        repository.insert(teacherEntity);
        TeacherEntity entity = repository.getById(1L);
        assertNotNull(entity);
        assertEquals(entity.getId(), teacherEntity.getId());
    }

    @Test
    void update() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1L);
        teacherEntity.setPassword("hi");
        TeacherEntity update = repository.update(teacherEntity);
        assertNotEquals(update, teacherEntity);
    }

    @Test
    void removeById() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1L);
        repository.insert(teacherEntity);
        assertFalse(repository.list().isEmpty());
        repository.removeById(1L);
        assertTrue(repository.list().isEmpty());
    }

    @Test
    void login() {
        getByUsername();
    }

    @Test
    void getCount() {
        repository.insert(new TeacherEntity());
        assertEquals(1, repository.getCount());
        repository.insert(new TeacherEntity());
        assertEquals(2, repository.getCount());
        repository.insert(new TeacherEntity());
        assertEquals(3, repository.getCount());
        repository.insert(new TeacherEntity());
        assertEquals(4, repository.getCount());
    }

    @Test
    void getByUsername() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setUsername("abusalah");
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> repository.getByUsername("abusalah"));
        assertEquals("teacher not found with username = abusalah", exception.getMessage());
        repository.insert(teacherEntity);
        TeacherEntity entity = repository.getByUsername("abusalah");
        assertNotNull(entity);
        assertEquals(entity.getUsername(), teacherEntity.getUsername());
    }

    @Test
    void existById() {
        assertFalse(repository.existById(1L));
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1L);
        repository.insert(teacherEntity);
        assertTrue(repository.existById(1L));
    }
}
