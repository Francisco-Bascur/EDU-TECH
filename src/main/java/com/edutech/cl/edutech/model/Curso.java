package com.edutech.cl.edutech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table (name = "Curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String tutor;

    @Column(nullable = false)
    private Integer diasTotales;

    @Column(nullable = false)
    private Integer totalAlumnos;
}
