package com.example.ssjava.demo.controller;

import com.example.ssjava.demo.dto.RespuestaExamenDto;
import com.example.ssjava.demo.entity.ResultadoExamen;
import com.example.ssjava.demo.excepciones.BadRequestException;
import com.example.ssjava.demo.excepciones.NotFoundException;
import com.example.ssjava.demo.service.ResultadoExamenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/resultados-examen")
public class ResultadoExamenController {

    private ResultadoExamenService resultadoExamenService;
    @PostMapping
    public ResponseEntity<ResultadoExamen> createResultadoExamen(@RequestBody RespuestaExamenDto respuestaExamenDto) {
        try {
            ResultadoExamen resultadoExamen = resultadoExamenService.createResultadoExamen(respuestaExamenDto);
            return ResponseEntity.ok(resultadoExamen);
        } catch (NotFoundException | BadRequestException e) {
            throw e;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<ResultadoExamen>> getAllResultById(@PathVariable Long id) {
        List<ResultadoExamen> resultados = resultadoExamenService.getAllResultById(id);
        if (resultados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }

}
