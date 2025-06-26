package com.edutech.cl.edutech.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length=50)
    private String nombre;

    @Column(nullable = false, length=50)
    private String apellido;

    @Column(name = "run", nullable = false, unique = true, length=10)
    private String run;  

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(nullable = false, unique = true, length=50)
    private String email;

    @Column(nullable = false, length=30)
    private String contraseña;  
}