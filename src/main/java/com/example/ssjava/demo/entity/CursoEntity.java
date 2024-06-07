package com.example.ssjava.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cursos")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCursos;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "id_clase", unique = true, nullable = false)
    private ClaseEntity clase;

    @OneToOne
    @JoinColumn(name = "id_plan", unique = true, nullable = false)
    private PlanEntity plan;
}
