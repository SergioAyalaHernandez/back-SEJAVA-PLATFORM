package com.example.ssjava.demo.controller;

import com.example.ssjava.demo.dto.IdPreguntasDTO;
import com.example.ssjava.demo.entity.RespuestaEntity;
import com.example.ssjava.demo.projection.RespuestaProjection;
import com.example.ssjava.demo.service.RespuestaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/respuestas")
public class RespuestaController {

    private RespuestaService respuestaService;

    @GetMapping
    public List<RespuestaEntity> getAllRespuestas() {
        return respuestaService.getAllRespuestas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaEntity> getRespuestaById(@PathVariable int id) {
        Optional<RespuestaEntity> respuesta = respuestaService.getRespuestaById(id);
        return respuesta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RespuestaEntity createRespuesta(@RequestBody RespuestaEntity respuesta) {
        return respuestaService.createRespuesta(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaEntity> updateRespuesta(@PathVariable int id, @RequestBody RespuestaEntity respuesta) {
        try {
            return ResponseEntity.ok(respuestaService.updateRespuesta(id, respuesta));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/respuestas-por-pregunta")
    public List<RespuestaProjection> getRespuestasByPreguntaIds(@RequestBody IdPreguntasDTO idPreguntasDTO) {
        return respuestaService.getRespuestasByPreguntaIds(idPreguntasDTO.getIdPreguntas());
    }
}
