package com.edutech.cl.edutech.controller;

import com.edutech.cl.edutech.model.Contenido;
import com.edutech.cl.edutech.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public ResponseEntity<List<Contenido>> listar() {
        List<Contenido> contenidos = contenidoService.findAll();
        return contenidos.isEmpty() 
            ? ResponseEntity.noContent().build() 
            : ResponseEntity.ok(contenidos);
    }

    @PostMapping
    public ResponseEntity<Contenido> guardar(@RequestBody Contenido contenido) {
        Contenido nuevoContenido = contenidoService.save(contenido);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoContenido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> buscar(@PathVariable Integer id) {
        try {
            Contenido contenido = contenidoService.findById(id);
            return ResponseEntity.ok(contenido);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenido> actualizar(
        @PathVariable Integer id, 
        @RequestBody Contenido contenido
    ) {
        try {
            Contenido contenidoExistente = contenidoService.findById(id);
            contenidoExistente.setTitulo(contenido.getTitulo());
            contenidoExistente.setDescripcion(contenido.getDescripcion());
            contenidoExistente.setTipo(contenido.getTipo());
            contenidoExistente.setUrlRecurso(contenido.getUrlRecurso());
            contenidoExistente.setDuracionMinutos(contenido.getDuracionMinutos());

            Contenido contenidoActualizado = contenidoService.save(contenidoExistente);
            return ResponseEntity.ok(contenidoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            contenidoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}