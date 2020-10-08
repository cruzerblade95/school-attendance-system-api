package com.bau.graduateprojects.qrstudentsattendance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
public class Test {
    @GetMapping
    public String hello() {
        return "hello";
    }
}
