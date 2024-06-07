package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.CursoEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CursoRepository extends ListCrudRepository<CursoEntity, Long> {
}
