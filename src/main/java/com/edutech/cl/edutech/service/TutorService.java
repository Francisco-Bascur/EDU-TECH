package com.edutech.cl.edutech.service;

import com.edutech.cl.edutech.model.Tutor;
import com.edutech.cl.edutech.repository.TutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TutorService {
    
    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> findall() {
        return tutorRepository.findAll();
    }

    public Tutor FIndById(long id) {
        return tutorRepository.findById(id).get();
    }

    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public void delete(Long id) {
        tutorRepository.deleteById(id);
    }

}
