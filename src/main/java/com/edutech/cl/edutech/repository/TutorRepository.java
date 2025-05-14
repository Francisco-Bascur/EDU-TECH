package com.edutech.cl.edutech.repository;

import com.edutech.cl.edutech.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{

}
