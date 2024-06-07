package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.PersonaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonaRepository extends ListCrudRepository<PersonaEntity, Long> {
}
