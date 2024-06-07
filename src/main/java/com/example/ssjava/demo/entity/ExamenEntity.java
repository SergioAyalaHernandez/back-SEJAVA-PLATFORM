package com.example.ssjava.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "examen")
public class ExamenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExamen;

    @Column(nullable = false, length = 200)
    private String preguntas;

    @Column(nullable = false, length = 200)
    private String respuestas;

    @Column(nullable = false)
    private int numeroCorrecto;

    @OneToOne
    @JoinColumn(name = "id_curso", unique = true, nullable = false)
    private CursoEntity curso;
}
