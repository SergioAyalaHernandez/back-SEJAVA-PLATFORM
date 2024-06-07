package com.example.ssjava.demo.service.impl;

import com.example.ssjava.demo.entity.ExamenEntity;
import com.example.ssjava.demo.repository.ExamenRepository;
import com.example.ssjava.demo.service.ExamenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExamenServiceImpl implements ExamenService {

    private ExamenRepository examenRepository;

    @Override
    public List<ExamenEntity> getAllExamenes() {
        return examenRepository.findAll();
    }

    @Override
    public Optional<ExamenEntity> getExamenById(Long id) {
        return examenRepository.findById(id);
    }

    @Override
    public ExamenEntity createExamen(ExamenEntity examen) {
        return examenRepository.save(examen);
    }

    @Override
    public ExamenEntity updateExamen(Long id, ExamenEntity examen) {
        Optional<ExamenEntity> existingExamen = examenRepository.findById(id);
        if (existingExamen.isPresent()) {
            ExamenEntity updatedExamen = existingExamen.get();
            updatedExamen.setTitulo(examen.getTitulo());
            updatedExamen.setContenido(examen.getContenido());
            updatedExamen.setCurso(examen.getCurso());
            return examenRepository.save(updatedExamen);
        } else {
            throw new RuntimeException("Examen not found with id " + id);
        }
    }
}

