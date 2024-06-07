package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.PlanEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PlanRepository extends ListCrudRepository<PlanEntity,Long> {
}
