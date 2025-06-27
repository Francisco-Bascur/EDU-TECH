package com.edutech.cl.edutech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TutorController {

    private final List<String> tutores = new ArrayList<>(List.of("Tutor 1", "Tutor 2", "Tutor 3"));

    @GetMapping("/tutores")
    public List<String> getTutores() {
        return tutores;
    }

    @PostMapping("/tutores")
    public String agregarTutor(@RequestBody String nuevoTutor) {
        tutores.add(nuevoTutor);
        return "Tutor agregado: " + nuevoTutor;
    }
}
