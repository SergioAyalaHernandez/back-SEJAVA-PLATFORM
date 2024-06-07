package com.example.ssjava.demo.service;

import com.example.ssjava.demo.entity.PreguntaEntity;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {
    List<PreguntaEntity> getAllPreguntas();
    Optional<PreguntaEntity> getPreguntaById(Long id);
    List<PreguntaEntity> getAllByIdCurso(Long id);
    PreguntaEntity createPregunta(PreguntaEntity pregunta);
    PreguntaEntity updatePregunta(Long id, PreguntaEntity pregunta);
}
