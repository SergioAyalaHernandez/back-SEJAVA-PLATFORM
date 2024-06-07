package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.RespuestaEntity;
import com.example.ssjava.demo.projection.RespuestaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaEntity, Integer> {
    @Query("SELECT r.idRespuesta AS idRespuesta, r.pregunta.idPregunta AS idPregunta, r.respuesta AS respuesta FROM RespuestaEntity r WHERE r.pregunta.idPregunta IN :idPreguntas")
    List<RespuestaProjection> findRespuestasByPreguntaIds(List<Integer> idPreguntas);
}
