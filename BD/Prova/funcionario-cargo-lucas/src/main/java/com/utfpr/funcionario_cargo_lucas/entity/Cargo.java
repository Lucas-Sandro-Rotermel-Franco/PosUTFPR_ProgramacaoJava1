package com.utfpr.funcionario_cargo_lucas.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cargo")
@Data
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cargo", nullable = false)
    private Long id;

    @Column(name = "cargo", nullable = false, length = 50)
    private String cargo;

    @OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Funcionario> funcionarios;

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", cargo='" + cargo + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
