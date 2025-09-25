package com.utfpr.funcionario_cargo_lucas.service;

import com.utfpr.funcionario_cargo_lucas.entity.Funcionario;
import com.utfpr.funcionario_cargo_lucas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salva(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Funcionario> listaTodosFuncionario() {
        return repository.findAll();
    }

    public List<Funcionario> listaTodosPorNomeAsc() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Long qtdFuncionario() {
        return repository.count();
    }
}
