package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.ClaseEntity;
import com.example.ssjava.demo.projection.ClasesPorProfesorProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ClaseRepository extends ListCrudRepository<ClaseEntity, Long> {
    @Query(value = "SELECT profesor, COUNT(*) AS cantidad \n" +
            "FROM clases c\n" +
            "GROUP BY profesor;", nativeQuery = true)
    List<ClasesPorProfesorProjection> findClasesPorProfesor();
}
