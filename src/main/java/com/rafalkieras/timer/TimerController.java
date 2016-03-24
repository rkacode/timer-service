package com.rafalkieras.timer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api/timer")
public class TimerController {

    @RequestMapping(value = "/date")
    public LocalDate getDate() {
        return LocalDate.now();
    }

    @RequestMapping(value = "/time")
    public LocalDateTime getTime() {
        return LocalDateTime.now();
    }

    @RequestMapping(value = "/day")
    public String getDay() {

        return LocalDate.now().getDayOfWeek().toString();
    }

}
