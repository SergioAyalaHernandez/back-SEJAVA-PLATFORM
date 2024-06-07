package com.example.ssjava.demo.controller;

import com.example.ssjava.demo.entity.PreguntaEntity;
import com.example.ssjava.demo.service.PreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/preguntas")
public class PreguntaController {


    private PreguntaService preguntaService;
    @GetMapping
    public List<PreguntaEntity> getAllPreguntas() {
        return preguntaService.getAllPreguntas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreguntaEntity> getPreguntaById(@PathVariable Long id) {
        Optional<PreguntaEntity> pregunta = preguntaService.getPreguntaById(id);
        return pregunta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PreguntaEntity createPregunta(@RequestBody PreguntaEntity pregunta) {
        return preguntaService.createPregunta(pregunta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreguntaEntity> updatePregunta(@PathVariable Long id, @RequestBody PreguntaEntity pregunta) {
        try {
            return ResponseEntity.ok(preguntaService.updatePregunta(id, pregunta));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/curso/{idCurso}")
    public List<PreguntaEntity> getPreguntasByCursoId(@PathVariable Long idCurso) {
        return preguntaService.getAllByIdCurso(idCurso);
    }
}
