package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.RespuestasAlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestasAlumnoRepository extends JpaRepository<RespuestasAlumnoEntity, Integer> {
}
