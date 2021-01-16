package com.bau.graduateprojects.qrstudentsattendance.repositories.secret;

import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class MockSecretRepository implements SecretRepository {
    Map<Long, String> map = new HashMap<Long, String>() {{
        put(1L, "key1");
        put(2L, "key2");
        put(3L, "key3");
        put(4L, "key4");
        put(5L, "key5");
    }};

    @Override
    public String getKey(Long cId) {
        if (!map.containsKey(cId))
            throw new ResourceNotFoundException("key not found with id = " + cId);
        return map.get(cId);
    }
}
