package com.example.ssjava.demo.service;

import com.example.ssjava.demo.entity.ExamenEntity;

import java.util.List;
import java.util.Optional;

public interface ExamenService {
    List<ExamenEntity> getAllExamenes();
    Optional<ExamenEntity> getExamenById(Long id);
    ExamenEntity createExamen(ExamenEntity examen);
    ExamenEntity updateExamen(Long id, ExamenEntity examen);
}
