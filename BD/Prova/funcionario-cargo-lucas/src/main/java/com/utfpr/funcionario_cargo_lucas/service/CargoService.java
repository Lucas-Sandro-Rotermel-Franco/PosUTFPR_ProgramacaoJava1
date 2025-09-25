package com.utfpr.funcionario_cargo_lucas.service;

import com.utfpr.funcionario_cargo_lucas.entity.Cargo;
import com.utfpr.funcionario_cargo_lucas.entity.Funcionario;
import com.utfpr.funcionario_cargo_lucas.repository.CargoRepository;
import com.utfpr.funcionario_cargo_lucas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Cargo salva(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Transactional(readOnly = false)
    public void salvaFuncECargo(Cargo cargo, Funcionario funcionario) {
        Cargo cargoSalvo = cargoRepository.save(cargo);
        funcionario.setCargo(cargoSalvo);
        funcionarioRepository.save(funcionario);
    }

    public void deleteById(Long id) {
        cargoRepository.deleteById(id);
    }

    public List<Cargo> buscaTodosCargos() {
        return cargoRepository.findAll();
    }
}
