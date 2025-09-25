package com.utfpr.funcionario_cargo_lucas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "funcionario")
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_funcionario", nullable = false)
    private Long id;

    @Column(name = "nome", length = 70)
    private String nome;

    @Column(name = "sexo", length = 10)
    private String sexo;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "cod_cargo")
    private Cargo cargo;

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", cargo=" + (cargo != null ? cargo.getCargo() : "null") +
                ", nome=" + nome +
                ", sexo=" + sexo +
                ", telefone=" + telefone + '\'' +
                '}';
    }
}
