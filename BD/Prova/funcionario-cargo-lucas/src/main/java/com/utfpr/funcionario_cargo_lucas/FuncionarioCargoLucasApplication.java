package com.utfpr.funcionario_cargo_lucas;

import com.utfpr.funcionario_cargo_lucas.entity.Cargo;
import com.utfpr.funcionario_cargo_lucas.entity.Funcionario;
import com.utfpr.funcionario_cargo_lucas.service.CargoService;
import com.utfpr.funcionario_cargo_lucas.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FuncionarioCargoLucasApplication {

    private static final Logger log = LoggerFactory.getLogger(FuncionarioCargoLucasApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FuncionarioCargoLucasApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(CargoService cargoService, FuncionarioService funcionarioService) {

        return (arg) -> {
            log.info("");
            log.info("");
            log.info("==================Inserir 3 CARGOS");

            Cargo cargoTI = new Cargo();
            cargoTI.setCargo("TI");
            cargoTI = cargoService.salva(cargoTI);


            Cargo cargoSup = new Cargo();
            cargoSup.setCargo("Suporte");
            cargoSup = cargoService.salva(cargoSup);

            Cargo cargoRH = new Cargo();
            cargoRH.setCargo("RH");
            cargoRH = cargoService.salva(cargoRH);

            log.info("==================Finalizado inserção de CARGOS");
            log.info("");
            log.info("");
            log.info("==================Inserir 3 FUNCIONARIOS");

            Funcionario funcionarioLucas = new Funcionario();
            funcionarioLucas.setCargo(cargoTI);
            funcionarioLucas.setNome("Lucas");
            funcionarioLucas.setSexo("Masculino");
            funcionarioLucas.setTelefone("99894083");
            funcionarioLucas = funcionarioService.salva(funcionarioLucas);

            Funcionario funcionariaMaria = new Funcionario();
            funcionariaMaria.setCargo(cargoSup);
            funcionariaMaria.setNome("Maria");
            funcionariaMaria.setSexo("Feminino");
            funcionariaMaria.setTelefone("57945843");
            funcionariaMaria = funcionarioService.salva(funcionariaMaria);

            Funcionario funcionarioMarlon = new Funcionario();
            funcionarioMarlon.setCargo(cargoRH);
            funcionarioMarlon.setNome("Marlon");
            funcionarioMarlon.setSexo("Masculino");
            funcionarioMarlon.setTelefone("895242");
            funcionarioMarlon = funcionarioService.salva(funcionarioMarlon);

            log.info("==================Finalizado inserção de FUNCIONARIOS");
            log.info("");
            log.info("");
            log.info("==================Excluir 1 CARGO");

            long id = 1;
            cargoService.deleteById(id);

            log.info("==================Finalizado exclusão de CARGO");
            log.info("");
            log.info("");
            log.info("==================Excluir 1 FUNCIONARIO");

            id = 3;
            funcionarioService.deleteById(id);

            log.info("==================Finalizado exclusão de FUNCIONARIO");
            log.info("");
            log.info("");
            log.info("==================Listar todos os FUNCIONARIOS");

            for (Funcionario funcionario : funcionarioService.listaTodosFuncionario())
                log.info(funcionario.toString());

            log.info("==================Finalizado lista de FUNCIONARIOS");
            log.info("");
            log.info("");
            log.info("==================Listar todos os CARGOS");

            for (Cargo cargo : cargoService.buscaTodosCargos())
                log.info(cargo.toString());

            log.info("==================Finalizado lista de CARGOS");
            log.info("");
            log.info("");
            log.info("==================Listar todos os FUNCIONARIOS em ORDEM ALFABETICA");

            for (Funcionario funcionario : funcionarioService.listaTodosPorNomeAsc())
                log.info(funcionario.toString());

            log.info("==================Finalizado lista de FUNCIONARIOS em ORDEM ALFABETICA");
            log.info("");
            log.info("");
            log.info("==================Listar quantidade de FUNCIONARIOS");

            log.info(funcionarioService.qtdFuncionario().toString());

            log.info("==================Finalizado lista de quantidade de FUNCIONARIOS");
            log.info("");
            log.info("");
        };
    }
}
