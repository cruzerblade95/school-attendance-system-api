package com.bau.graduateprojects.qrstudentsattendance.repositories.secret;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SecretRepositoryImplTest {

    private MockSecretRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MockSecretRepository();
    }

    @Test
    void getKey() {
        String key = repository.getKey(2L);
        assertNotNull(key);
        assertEquals("key2", key);
    }
}
