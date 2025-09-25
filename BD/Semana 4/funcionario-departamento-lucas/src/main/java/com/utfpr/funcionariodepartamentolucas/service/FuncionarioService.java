package com.utfpr.funcionariodepartamentolucas.service;

import com.utfpr.funcionariodepartamentolucas.entity.Funcionario;
import com.utfpr.funcionariodepartamentolucas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public void salvar(Funcionario funcionario) {
        repository.save(funcionario);
    }

    public Optional <Funcionario> buscaPorId(Long id) {
        return repository.findById(id);
    }

    public List<Funcionario> buscarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarPorNomeEDependente(String nome, Long dependentes) {
        return repository.findFirstByNomeAndQtdDependentes(nome, dependentes);
    }

    public List<Funcionario> buscarPorDepartamento(Long idDepartamento) {
        return repository.findByDepartamento(idDepartamento);
    }

    public Funcionario buscarMaiorSalario() {
        return repository.findFirst1ByOrderBySalarioDesc();
    }

    public List<Funcionario> buscarTop3MaioresSalarios() {
        return repository.findFirst3ByOrderBySalarioDesc();
    }

    public List<Funcionario> buscarSemDependentesOrdenadoPorNome() {
        return repository.findAllByQtdDependentesOrderByNomeAsc();
    }

    public List<Funcionario> buscarPorSalarioMaiorQue(Double salarioMinimo) {
        return repository.findAllBySalarioAfter(salarioMinimo);
    }

    public List<Funcionario> buscarPorSalarioMaiorQueNative(Double salarioMinimo) {
        return repository.findAllBySalarioAfterNativeQuery(salarioMinimo);
    }

    public List<Funcionario> buscarPorQtdDependentes(Long qtd) {
        return repository.findByQtdDependentes(qtd);
    }

    public List<Funcionario> buscarPorNomeParcial(String nome) {
        return repository.findByLikeName(nome);
    }

    //1
    @Transactional(readOnly = false)
    public void aumentaSalarioFuncionarios(Integer porcentagem) {
        repository.aumentaSalario(porcentagem);
    }

    //2
    @Transactional(readOnly = true)
    public List<Funcionario> buscaPorDepartamentoNomeado(Integer departamentoId) {
        return repository.findALlByDepartamento(departamentoId);
    }

    //3
    @Transactional(readOnly = false)
    public int atualizaDepFuncionarios(Integer depIdNew, Integer depIdOld) {
        return repository.updateDepartamentoByDepOld(depIdNew, depIdOld);
    }

    //4
    @Transactional(readOnly = false)
    public int removeFuncionariosPorDepartamento(Integer depId) {
        return repository.deleteByDepartamento(depId);
    }
}
