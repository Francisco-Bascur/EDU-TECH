package com.edutech.cl.edutech.service;

import com.edutech.cl.edutech.model.Curso;
import com.edutech.cl.edutech.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findall() {
        return cursoRepository.findAll();
    }

    public Curso FIndById(long id) {
        return cursoRepository.findById(id).get();
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }

}
