package com.edutech.cl.edutech.service;

import com.edutech.cl.edutech.model.Tutor;
import com.edutech.cl.edutech.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> findAll() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> findById(Integer id) {
        return tutorRepository.findById(id);
    }

    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public void delete(Integer id) {
        tutorRepository.deleteById(id);
    }
}
