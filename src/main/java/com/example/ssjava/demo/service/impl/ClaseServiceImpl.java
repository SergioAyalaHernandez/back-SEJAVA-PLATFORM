package com.example.ssjava.demo.service.impl;

import com.example.ssjava.demo.entity.ClaseEntity;
import com.example.ssjava.demo.repository.ClaseRepository;
import com.example.ssjava.demo.service.ClasesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClaseServiceImpl implements ClasesService {

    private ClaseRepository claseRepository;

    @Override
    public List<ClaseEntity> getAllClases() {
        return claseRepository.findAll();
    }

    @Override
    public Optional<ClaseEntity> getClaseById(Long id) {
        return claseRepository.findById(id);
    }

    @Override
    public ClaseEntity createClase(ClaseEntity clase) {
        return claseRepository.save(clase);
    }

    @Override
    public ClaseEntity updateClase(Long id, ClaseEntity clase) {
        Optional<ClaseEntity> existingClase = claseRepository.findById(id);
        if (existingClase.isPresent()) {
            ClaseEntity updatedClase = existingClase.get();
            updatedClase.setProfesor(clase.getProfesor());
            updatedClase.setContenido(clase.getContenido());
            updatedClase.setLinkClase(clase.getLinkClase());
            updatedClase.setEjemplosCodigo(clase.getEjemplosCodigo());
            return claseRepository.save(updatedClase);
        } else {
            throw new RuntimeException("Clase not found with id " + id);
        }
    }

}
