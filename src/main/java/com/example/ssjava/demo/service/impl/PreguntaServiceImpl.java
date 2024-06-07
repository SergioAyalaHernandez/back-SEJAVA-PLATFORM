package com.example.ssjava.demo.service.impl;

import com.example.ssjava.demo.entity.PreguntaEntity;
import com.example.ssjava.demo.repository.PreguntaRepository;
import com.example.ssjava.demo.service.PreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PreguntaServiceImpl implements PreguntaService {


    private PreguntaRepository preguntaRepository;

    @Override
    public List<PreguntaEntity> getAllPreguntas() {
        return preguntaRepository.findAll();
    }

    @Override
    public Optional<PreguntaEntity> getPreguntaById(Long id) {
        return preguntaRepository.findById(id);
    }

    @Override
    public PreguntaEntity createPregunta(PreguntaEntity pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public PreguntaEntity updatePregunta(Long id, PreguntaEntity pregunta) {
        Optional<PreguntaEntity> existingPregunta = preguntaRepository.findById(id);
        if (existingPregunta.isPresent()) {
            PreguntaEntity updatedPregunta = existingPregunta.get();
            updatedPregunta.setDescripcion(pregunta.getDescripcion());
            updatedPregunta.setExamen(pregunta.getExamen());
            return preguntaRepository.save(updatedPregunta);
        } else {
            throw new RuntimeException("Pregunta not found with id " + id);
        }
    }

    @Override
    public List<PreguntaEntity> getAllByIdCurso(Long idCurso) {
        return preguntaRepository.findByCursoId(idCurso);
    }
}
