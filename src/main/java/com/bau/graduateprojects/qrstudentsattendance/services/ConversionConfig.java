package com.bau.graduateprojects.qrstudentsattendance.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ConversionConfig {

    private final String timeZone;

    public ConversionConfig(@Value("${service.time-zone}") String timeZone) {
        this.timeZone = timeZone;
    }

    @PostConstruct
    public void initTimeServiceTimeZone() {
        DateTimeService.initialize(timeZone);
    }


}
