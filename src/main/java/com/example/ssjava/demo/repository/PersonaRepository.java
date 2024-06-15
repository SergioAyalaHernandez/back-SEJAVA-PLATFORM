package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.PersonaEntity;
import com.example.ssjava.demo.projection.EstudiantesPorPlanProjection;
import com.example.ssjava.demo.projection.UsuariosActivosPorMesProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends ListCrudRepository<PersonaEntity, Long> {
    @Query(value = "select * from ssjava.persona where email = :email", nativeQuery = true)
    Optional<PersonaEntity> findByEmail(String email);

    @Query(value = "SELECT plan.tipo_plan, COUNT(persona.id_persona) as cantidad_estudiantes\n" +
            "FROM persona\n" +
            "JOIN plan ON persona.plan_FK = plan.id_plan\n" +
            "GROUP BY plan.tipo_plan;", nativeQuery = true)
    List<EstudiantesPorPlanProjection> findEstudiantesPorPlan();

    @Query(value = "SELECT DATE_FORMAT(fecha_creacion, '%Y-%m') AS mes, " +
            "COUNT(*) as cantidad\n" +
            "FROM persona\n" +
            "GROUP BY mes;",nativeQuery = true)
    List<UsuariosActivosPorMesProjection> findNuevosUsuariosPorMes();
}
