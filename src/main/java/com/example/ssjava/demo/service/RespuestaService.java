package com.example.ssjava.demo.service;

import com.example.ssjava.demo.entity.RespuestaEntity;
import com.example.ssjava.demo.projection.RespuestaProjection;

import java.util.List;
import java.util.Optional;

public interface RespuestaService {
    List<RespuestaEntity> getAllRespuestas();
    Optional<RespuestaEntity> getRespuestaById(int id);
    RespuestaEntity createRespuesta(RespuestaEntity respuesta);
    RespuestaEntity updateRespuesta(int id, RespuestaEntity respuesta);
    List<RespuestaProjection> getRespuestasByPreguntaIds(List<Integer> idPreguntas);
}
