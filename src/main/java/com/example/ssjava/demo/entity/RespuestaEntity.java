package com.example.ssjava.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "respuestas")
public class RespuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @ManyToOne
    @JoinColumn(name = "id_pregunta", nullable = false)
    private PreguntaEntity pregunta;

    @Column(nullable = false)
    private String respuesta;

    @Column(nullable = false)
    private boolean esCorrecta;
}
