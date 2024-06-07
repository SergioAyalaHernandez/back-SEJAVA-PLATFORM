package com.example.ssjava.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaExamenDto {
    private Long idPersona;
    private Long idExamen;
    private List<Long> idPreguntas;
    private List<Long> idRespuestas;
}
