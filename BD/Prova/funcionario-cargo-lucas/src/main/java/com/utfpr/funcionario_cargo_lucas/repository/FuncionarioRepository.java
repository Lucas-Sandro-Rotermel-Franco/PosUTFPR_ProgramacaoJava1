package com.utfpr.funcionario_cargo_lucas.repository;

import com.utfpr.funcionario_cargo_lucas.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
