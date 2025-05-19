package com.edutech.cl.edutech.controller;

import com.edutech.cl.edutech.model.Alumno;
import com.edutech.cl.edutech.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> listar() {
        List<Alumno> alumnos = alumnoService.findall();
        if (alumnos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alumnos);
    }

    @PostMapping
    public ResponseEntity<Alumno> guardar(@RequestBody Alumno alumno) {
        Alumno alumnoNuevo = alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> buscar(@PathVariable Integer id){
        try{
            Alumno alumno = alumnoService.FIndById(id);
            return ResponseEntity.ok(alumno);
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Integer id, @RequestBody Alumno alumno) {
        try {
            Alumno alm = alumnoService.FIndById(id);
            alm.setId(id);
            alm.setRun(alumno.getRun());
            alm.setNombre(alumno.getNombre());
            alm.setApellidos(alumno.getApellidos());
            alm.setCurso(alumno.getCurso());
            alm.setNivel(alumno.getNivel());

            alumnoService.save(alm);
            return ResponseEntity.ok(alumno);
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            alumnoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }
}
