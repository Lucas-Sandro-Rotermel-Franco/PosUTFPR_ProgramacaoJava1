package com.utfpr.funcionariodepartamentolucas.repository;

import com.utfpr.funcionariodepartamentolucas.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findFirstByNomeAndQtdDependentes(String nome, Long qtdDependentes);

    //1
    @Procedure(name = "Funcionario.aumentaSalario")
    void aumentaSalario(@Param("porcentagem") Integer porcentagem);

    //2
    @Query ("select f from Funcionario f where f.departamento.id = :dep_id")
    List<Funcionario> findALlByDepartamento(@Param("dep_id") Integer depId);

    //3
    @Modifying
    @Query("update Funcionario f set f.departamento.id = :dep_id_new where f.departamento.id = :dep_id_old")
    int updateDepartamentoByDepOld(@Param("dep_id_new") Integer depIdNew, @Param("dep_id_old") Integer depIdOld);

    //4
    @Modifying
    @Query("delete from Funcionario f where f.departamento.id = :dep_id")
    int deleteByDepartamento(@Param("dep_id") Integer depId);

    @Query ("select f from Funcionario f where f.departamento.id = ?1")
    List<Funcionario> findByDepartamento(Long nrCodigoDepartamento);

    Funcionario findFirst1ByOrderBySalarioDesc();

    List<Funcionario> findFirst3ByOrderBySalarioDesc();

    @Query ("select f from Funcionario f where f.qtdDependentes = 0 order by nome asc")
    List<Funcionario> findAllByQtdDependentesOrderByNomeAsc();

    @Query ("select f from Funcionario f where  f.salario > ?1")
    List<Funcionario> findAllBySalarioAfter(Double salario);

    @Query(value = "select * from funcionario f where f.salario > ?1", nativeQuery = true)
    List<Funcionario> findAllBySalarioAfterNativeQuery(Double salario);

    @Query(name = "Funcionario.byQtdDependentes")
    List<Funcionario> findByQtdDependentes(Long qtdDependentes);

    @Query(name = "Funcionario.byLikeName")
    List<Funcionario> findByLikeName(String nome);
}
