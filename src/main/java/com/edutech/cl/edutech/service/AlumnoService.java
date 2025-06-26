package com.edutech.cl.edutech.service;

import com.edutech.cl.edutech.model.Alumno;
import com.edutech.cl.edutech.repository.AlumnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno findById(Integer id) {
        return alumnoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Alumno no encontrado"));
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void delete(Integer id) {
        alumnoRepository.deleteById(id);
    }

    // Métodos personalizados (opcionales):
    public Alumno findByRun(String run) {
        return alumnoRepository.findByRun(run);
    }
}