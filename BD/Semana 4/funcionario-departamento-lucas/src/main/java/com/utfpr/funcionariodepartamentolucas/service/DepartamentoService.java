package com.utfpr.funcionariodepartamentolucas.service;

import com.utfpr.funcionariodepartamentolucas.entity.Departamento;
import com.utfpr.funcionariodepartamentolucas.entity.Funcionario;
import com.utfpr.funcionariodepartamentolucas.repository.DepartamentoRepository;
import com.utfpr.funcionariodepartamentolucas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    //5
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void salva(Departamento departamento) {
        departamentoRepository.save(departamento);
    }

    public Optional <Departamento> buscaPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    public List<Departamento> buscaTodos() {
        return departamentoRepository.findAll();
    }

    public Departamento listaPrimeiroDepartamento() {
        return departamentoRepository.findFirst1ByOrderByIdDesc();
    }

    @Transactional(readOnly = false)
    public void salvarDepartamentoEFuncionario(Departamento departamento, Funcionario funcionario) {
        departamentoRepository.save(departamento);
        funcionario.setDepartamento(departamento);
        funcionarioRepository.save(funcionario);
    }
}
