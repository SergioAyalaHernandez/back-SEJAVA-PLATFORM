package com.example.ssjava.demo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "respuestas_alumno")
public class RespuestasAlumnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_respuesta", nullable = false)
    private RespuestaEntity respuesta;

    @ManyToOne
    @JoinColumn(name = "id_pregunta", nullable = false)
    private PreguntaEntity pregunta;

    @ManyToOne
    @JoinColumn(name = "id_examen", nullable = false)
    private ExamenEntity examen;

    @ManyToOne
    @JoinColumn(name = "id_resultado_examen", nullable = false)
    private ResultadoExamen resultadoExamen;
}
