package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.ResultadoExamen;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ResultadoRepository extends ListCrudRepository<ResultadoExamen,Long> {
    List<ResultadoExamen> findAllByPersona_IdPersona(Long idPersona);

}
