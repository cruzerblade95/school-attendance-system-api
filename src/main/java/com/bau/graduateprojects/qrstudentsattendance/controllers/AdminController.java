package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin";

    @PostMapping("/{username}/{password}")
    public Boolean check(@PathVariable String username, @PathVariable String password) {
        boolean result = username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
        if (!result) {
            throw new ResourceNotFoundException("admin data is wrong !");
        }
        return true;
    }

}
