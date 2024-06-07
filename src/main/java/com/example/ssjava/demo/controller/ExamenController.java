package com.example.ssjava.demo.controller;

import com.example.ssjava.demo.entity.ExamenEntity;
import com.example.ssjava.demo.service.ExamenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/examenes")
public class ExamenController {


    private ExamenService examenService;

    @GetMapping
    public List<ExamenEntity> getAllExamenes() {
        return examenService.getAllExamenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamenEntity> getExamenById(@PathVariable Long id) {
        Optional<ExamenEntity> examen = examenService.getExamenById(id);
        return examen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExamenEntity createExamen(@RequestBody ExamenEntity examen) {
        return examenService.createExamen(examen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamenEntity> updateExamen(@PathVariable Long id, @RequestBody ExamenEntity examen) {
        try {
            return ResponseEntity.ok(examenService.updateExamen(id, examen));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
