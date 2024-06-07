package com.example.ssjava.demo.controller;

import com.example.ssjava.demo.entity.ClaseEntity;
import com.example.ssjava.demo.service.ClasesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/clases")
@AllArgsConstructor
public class ClaseController {


    private ClasesService claseService;

    @GetMapping
    public List<ClaseEntity> getAllClases() {
        return claseService.getAllClases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseEntity> getClaseById(@PathVariable Long id) {
        Optional<ClaseEntity> clase = claseService.getClaseById(id);
        return clase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClaseEntity createClase(@RequestBody ClaseEntity clase) {
        return claseService.createClase(clase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseEntity> updateClase(@PathVariable Long id, @RequestBody ClaseEntity clase) {
        try {
            return ResponseEntity.ok(claseService.updateClase(id, clase));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}