package com.edutech.cl.edutech.service;

import com.edutech.cl.edutech.model.Contenido;
import com.edutech.cl.edutech.repository.ContenidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Contenido> findAll() {
        return contenidoRepository.findAll();
    }

    public Contenido findById(Integer id) {
        return contenidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
    }

    public Contenido save(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public void delete(Integer id) {
        contenidoRepository.deleteById(id);
    }
}