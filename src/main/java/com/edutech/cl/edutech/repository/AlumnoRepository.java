package com.edutech.cl.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.cl.edutech.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    // Métodos personalizados (opcionales):
    Alumno findByRun(String run);
    Alumno findByEmail(String email);
}