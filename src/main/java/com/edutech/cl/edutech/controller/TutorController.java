package com.edutech.cl.edutech.controller;

import com.edutech.cl.edutech.model.Tutor;
import com.edutech.cl.edutech.service.TutorService;
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
@RequestMapping("api/v1/tutores")
public class TutorController {

    @Autowired
    private TutorService TutorService;

    @GetMapping
    public ResponseEntity<List<Tutor>> listar() {
        List<Tutor> tutores = TutorService.findall();
        if (tutores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tutores);
    }

    @PostMapping
    public ResponseEntity<Tutor> guardar(@RequestBody Tutor tutor) {
        Tutor tutorNuevo = TutorService.save(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(tutorNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscar(@PathVariable Integer id){
        try{
            Tutor tutor = TutorService.FIndById(id);
            return ResponseEntity.ok(tutor);
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> actualizar(@PathVariable Integer id, @RequestBody Tutor tutor) {
        try {
            Tutor tut = TutorService.FIndById(id);
            tut.setId(id);
            tut.setRun(tutor.getRun());
            tut.setNombre(tutor.getNombre());
            tut.setApellidos(tutor.getApellidos());
            tut.setCurso(tutor.getCurso());
            tut.setNivel(tutor.getNivel());

            TutorService.save(tut);
            return ResponseEntity.ok(tutor);
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            TutorService.delete(id);
            return ResponseEntity.noContent().build();
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }
}
