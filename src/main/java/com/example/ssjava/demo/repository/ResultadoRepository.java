package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.ResultadoExamen;
import org.springframework.data.repository.ListCrudRepository;

public interface ResultadoRepository extends ListCrudRepository<ResultadoExamen,Long> {
}
