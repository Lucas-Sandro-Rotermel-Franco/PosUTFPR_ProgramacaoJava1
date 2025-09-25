package com.utfpr.funcionariodepartamentolucas.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="funcionario")

@NamedQuery(
        name = "Funcionario.byQtdDependentes",
        query = "from Funcionario f where f.qtdDependentes = ?1"
)

@NamedNativeQuery(
        name = "Funcionario.byLikeName",
        query = "select * from funcionario where nome like CONCAT('%', ?1, '%')",
        resultClass = Funcionario.class
)
//1
@NamedStoredProcedureQuery(name = "Funcionario.aumentaSalario",
procedureName = "AUMENTAR_SALARIO_FUNC", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "porcentagem", type = Integer.class)})
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_codigo", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "qtd_dependentes")
    @ColumnDefault("0")
    private Long qtdDependentes;

    @Column(name = "salario", nullable = false)
    private Double salario;

    @Column(name = "cargo", nullable = false, length = 255)
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "nr_codigo_departamento")
    private Departamento departamento;

    //5
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
