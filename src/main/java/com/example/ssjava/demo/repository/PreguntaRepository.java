package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.PreguntaEntity;
import com.example.ssjava.demo.projection.PreguntasPorExamenProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PreguntaRepository extends ListCrudRepository<PreguntaEntity,Long> {
    @Query("SELECT p FROM PreguntaEntity p WHERE p.examen.curso.idCursos = :idCurso")
    List<PreguntaEntity> findByCursoId(Long idCurso);

    @Query(value = "SELECT e.titulo, COUNT(*) as cantidad\n" +
            "FROM pregunta p\n" +
            "JOIN examen e ON p.id_examen = e.id_examen\n" +
            "GROUP BY e.titulo;", nativeQuery = true)
    List<PreguntasPorExamenProjection> findPreguntasPorExamen();
}
