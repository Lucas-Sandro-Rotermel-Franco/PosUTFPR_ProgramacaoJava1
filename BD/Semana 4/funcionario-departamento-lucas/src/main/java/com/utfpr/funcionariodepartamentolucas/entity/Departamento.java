package com.utfpr.funcionariodepartamentolucas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "departamento")
@Data
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_codigo", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
}
