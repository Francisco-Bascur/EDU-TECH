package com.edutech.cl.edutech.controller;

import com.edutech.tutor.model.Tutor;
import com.edutech.tutor.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    // Listar todos los tutores
    @GetMapping
    public List<Tutor> listar() {
        return tutorService.listar();
    }

    // Obtener tutor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tutor> obtener(@PathVariable Long id) {
        return tutorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo tutor
    @PostMapping
    public Tutor crear(@Valid @RequestBody Tutor tutor) {
        return tutorService.guardar(tutor);
    }

    // Actualizar tutor
    @PutMapping("/{id}")
    public ResponseEntity<Tutor> actualizar(@PathVariable Long id, @Valid @RequestBody Tutor nuevo) {
        return tutorService.obtenerPorId(id)
                .map(tutor -> {
                    tutor.setNombre(nuevo.getNombre());
                    tutor.setCorreo(nuevo.getCorreo());
                    tutor.setEspecialidad(nuevo.getEspecialidad());
                    return ResponseEntity.ok(tutorService.guardar(tutor));
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar tutor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (tutorService.obtenerPorId(id).isPresent()) {
            tutorService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


public class TutorController {


}
