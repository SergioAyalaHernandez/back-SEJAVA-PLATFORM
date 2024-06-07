package com.example.ssjava.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;


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

    @Column(nullable = false, length = 255)
    private String contenido;

    @Lob
    private String jsonEjemplo;

    @Lob
    private String ejemplosCodigo;
}
