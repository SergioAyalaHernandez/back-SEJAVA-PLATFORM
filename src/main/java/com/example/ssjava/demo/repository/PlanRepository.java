package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.PlanEntity;
import com.example.ssjava.demo.projection.EstudiantesPorPlanProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PlanRepository extends ListCrudRepository<PlanEntity,Long> {
    @Query(value = "SELECT plan.tipo_plan, COUNT(persona.id_persona) as cantidad\n" +
            "FROM persona\n" +
            "JOIN plan ON persona.plan_FK = plan.id_plan\n" +
            "GROUP BY plan.tipo_plan;", nativeQuery = true)
    List<EstudiantesPorPlanProjection> findEstudiantesPorPlan();
}
