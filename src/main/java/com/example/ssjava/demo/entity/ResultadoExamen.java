package com.example.ssjava.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "resultado_examen")
public class ResultadoExamen {
    @Id
    @Column(name = "id_resultado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResultado;
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private PersonaEntity persona;
    @ManyToOne
    @JoinColumn(name = "id_examen", nullable = false)
    private ExamenEntity examen;
    private Float resultado;
}
