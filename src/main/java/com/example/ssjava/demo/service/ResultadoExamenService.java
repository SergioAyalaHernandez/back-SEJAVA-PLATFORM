package com.example.ssjava.demo.service;

import com.example.ssjava.demo.dto.RespuestaExamenDto;
import com.example.ssjava.demo.entity.ResultadoExamen;

public interface ResultadoExamenService {
    ResultadoExamen createResultadoExamen(RespuestaExamenDto resultadoExamen);
}
