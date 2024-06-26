package com.example.ssjava.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "clases")
public class ClaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClase;

    @Column(nullable = false, length = 25)
    private String profesor;

    @Column(nullable = false)
    private String contenido;

    @Column(nullable = false, name = "link_clase")
    private String linkClase;

    @Column(name = "json_ejemplo")
    private String jsonEjemplo;

    @Column(name = "ejemplos_codigo",columnDefinition = "TEXT")
    private String ejemplosCodigo;
}