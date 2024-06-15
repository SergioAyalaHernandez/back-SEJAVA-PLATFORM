package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.RespuestasAlumnoEntity;
import com.example.ssjava.demo.projection.PreguntasAcertadasProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface RespuestasAlumnoRepository extends JpaRepository<RespuestasAlumnoEntity, Integer> {

    @Query(value = "SELECT p.descripcion, COUNT(r.id_respuesta) AS cantidad_respuestas_correctas\n" +
            "FROM respuestas_alumno ra\n" +
            "JOIN respuestas r ON ra.id_respuesta = r.id_respuesta\n" +
            "JOIN pregunta p ON r.id_pregunta = p.id_pregunta\n" +
            "WHERE r.es_correcta = TRUE\n" +
            "GROUP BY p.descripcion\n" +
            "ORDER BY cantidad_respuestas_correctas DESC\n" +
            "LIMIT 10;",nativeQuery = true)
    List<PreguntasAcertadasProjection> findPreguntasMasAcertadas();

    @Query(value = "SELECT p.descripcion, COUNT(r.id_respuesta) AS cantidad_respuestas_correctas\n" +
            "FROM respuestas_alumno ra\n" +
            "JOIN respuestas r ON ra.id_respuesta = r.id_respuesta\n" +
            "JOIN pregunta p ON r.id_pregunta = p.id_pregunta\n" +
            "WHERE r.es_correcta = TRUE\n" +
            "GROUP BY p.descripcion\n" +
            "ORDER BY cantidad_respuestas_correctas ASC\n" +
            "LIMIT 10;",nativeQuery = true)
    List<PreguntasAcertadasProjection> findPreguntasMenosAcertadas();
}
