package com.edutech.cl.edutech.controller;

import com.edutech.cl.edutech.model.Alumno;
import com.edutech.cl.edutech.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> listar() {
        List<Alumno> alumnos = alumnoService.findAll();
        return alumnos.isEmpty() 
            ? ResponseEntity.noContent().build() 
            : ResponseEntity.ok(alumnos);
    }

    @PostMapping
    public ResponseEntity<Alumno> guardar(@RequestBody Alumno alumno) {
        Alumno nuevoAlumno = alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAlumno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> buscar(@PathVariable Integer id) {
        try {
            Alumno alumno = alumnoService.findById(id);
            return ResponseEntity.ok(alumno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Integer id, @RequestBody Alumno alumno) {
        try {
            Alumno alumnoExistente = alumnoService.findById(id);
            alumnoExistente.setNombre(alumno.getNombre());
            alumnoExistente.setApellido(alumno.getApellido());
            alumnoExistente.setRun(alumno.getRun());
            alumnoExistente.setFechaNacimiento(alumno.getFechaNacimiento());
            alumnoExistente.setEmail(alumno.getEmail());
            alumnoExistente.setContraseña(alumno.getContraseña());

            Alumno alumnoActualizado = alumnoService.save(alumnoExistente);
            return ResponseEntity.ok(alumnoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            alumnoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}