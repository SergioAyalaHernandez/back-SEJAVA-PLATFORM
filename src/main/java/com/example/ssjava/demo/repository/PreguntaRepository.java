package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PreguntaRepository extends ListCrudRepository<PreguntaEntity,Long> {
    @Query("SELECT p FROM PreguntaEntity p WHERE p.examen.curso.idCursos = :idCurso")
    List<PreguntaEntity> findByCursoId(Long idCurso);
}
