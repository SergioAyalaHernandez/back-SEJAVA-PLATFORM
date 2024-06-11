package com.example.ssjava.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    private Float resultado;
}
