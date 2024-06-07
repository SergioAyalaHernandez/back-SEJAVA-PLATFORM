package com.example.ssjava.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    @Column(nullable = false, length = 65)
    private String nombres;

    @Column(nullable = false, length = 65)
    private String apellidos;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 75)
    private String password;

    @Column(nullable = false, length = 20)
    private String celular;

    @Column(nullable = false, length = 1)
    private String tipoUsuario;

    @ManyToOne
    @JoinColumn(name = "plan_FK", nullable = false)
    private PlanEntity plan;
}
