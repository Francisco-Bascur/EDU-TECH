package com.edutech.cl.edutech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TutorController {

    @GetMapping("/tutores")
    public List<String> getTutores() {
        return List.of("Tutor 1", "Tutor 2", "Tutor 3");
    }

}
