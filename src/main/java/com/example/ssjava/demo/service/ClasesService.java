package com.example.ssjava.demo.service;

import com.example.ssjava.demo.entity.ClaseEntity;

import java.util.List;
import java.util.Optional;

public interface ClasesService {
    List<ClaseEntity> getAllClases();
    Optional<ClaseEntity> getClaseById(Long id);
    ClaseEntity createClase(ClaseEntity clase);
    ClaseEntity updateClase(Long id, ClaseEntity clase);
}
