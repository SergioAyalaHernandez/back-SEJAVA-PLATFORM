package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.ExamenEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ExamenRepository extends ListCrudRepository<ExamenEntity, Long> {
}
