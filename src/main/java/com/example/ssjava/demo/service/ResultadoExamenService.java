package com.example.ssjava.demo.service;

import com.example.ssjava.demo.dto.RespuestaExamenDto;
import com.example.ssjava.demo.entity.ResultadoExamen;

import java.util.List;

public interface ResultadoExamenService {
    ResultadoExamen createResultadoExamen(RespuestaExamenDto resultadoExamen);
    List<ResultadoExamen> getAllResultById(Long id);
}
