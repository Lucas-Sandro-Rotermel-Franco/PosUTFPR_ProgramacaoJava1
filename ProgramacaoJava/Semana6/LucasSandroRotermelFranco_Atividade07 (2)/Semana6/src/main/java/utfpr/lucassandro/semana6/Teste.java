/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package utfpr.lucassandro.semana6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.lucassandro.semana6.BDVeiculos;
import static utfpr.lucassandro.semana6.BDVeiculos.cadastraPasseio;

/**
 *
 * @author lucassandro
 */
public class Teste {

    enum Modelos {
        Clio,
        Logan,
        Uno,
        Cruze,
        Ducato,
        Master,
        Meteor,
        Delivery
    }
    
    enum Marcas {
        Fiat,
        Renault,
        Chevrolet,
        Volkswagen
    }
    
    enum Cores {
        Vermelho,
        Branco,
        Preto,
        Azul
    }
    private static final int PASSEIO = 1;
    private static final int CARGA = 2;
    private static final int CADASTRAR_PASSEIO = 1;
    private static final int CADASTRAR_CARGA = 2;
    private static final int IMPRIMIR_PASSEIO = 3;
    private static final int IMPRIMIR_CARGA = 4;
    private static final int IMPRIMIR_PASSEIO_POR_PLACA = 5;
    private static final int IMPRIMIR_CARGA_POR_PLACA = 6;
    private static final int SAIR = 7;
    
    private static Passeio passeio = new Passeio();
    private static Carga carga = new Carga();
    private static BDVeiculos bdVeiculos = new BDVeiculos();
    private static Leitura leitura = new Leitura();
    
    public static void main(String[] args) {
        boolean continua = true;
        int opcao = 0;
        
        while (continua) {
            mostraOpcoes();
            
            try {
                opcao = Integer.parseInt(leitura.entDados("\n\tEscolha uma opção:"));
            } catch(NumberFormatException nfe) {
                System.out.println("Deve ser um valor inteiro - pressione <ENTER>");
                leitura.entDados("");
                
                continue;
            }
            
            switch (opcao) {
                case CADASTRAR_PASSEIO:
                    cadastraPasseio();
                break;
                
                case CADASTRAR_CARGA:
                    cadastraCarga();
                break;
                
                case IMPRIMIR_PASSEIO:
                    imprimeVeiculos(PASSEIO, "");
                break;
                
                case IMPRIMIR_CARGA:
                    imprimeVeiculos(CARGA, "");
                break;
                
                case IMPRIMIR_PASSEIO_POR_PLACA:
                    imprimeVeiculos(PASSEIO, leitura.entDados("Informe a placa: "));
                break;
                
                case IMPRIMIR_CARGA_POR_PLACA:
                    imprimeVeiculos(CARGA, leitura.entDados("Informe a placa: "));
                break;
                
                case SAIR:
                    continua = false;
                break;
                
                default:
                    leitura.entDados("\nO valor deve ser entre 1 e 7 - pressione <ENTER>");
                break;
                    
            }
        }
    }
    
    private static String obterMarca(String modelo) {
        if (modelo.equals(Modelos.Clio.toString()) || modelo.equals(Modelos.Logan.toString()) || modelo.equals(Modelos.Master.toString()))
            return Marcas.Renault.toString();
        
        if (modelo.equals(Modelos.Uno.toString()) || modelo.equals(Modelos.Ducato.toString()))
            return Marcas.Fiat.toString();
        
        if (modelo.equals(Modelos.Cruze.toString()))
            return Marcas.Chevrolet.toString();
        
        if (modelo.equals(Modelos.Delivery.toString()) || modelo.equals(Modelos.Meteor.toString()))
            return Marcas.Volkswagen.toString();
        
        return " ";
    }
    
    private static void mostraOpcoes() {
        System.out.println("\n\t\t\t Sistema de Gestão de Veículo - Menu Inicial");
        System.out.println("\t 1. Cadastrar Veículo de Passeio");
        System.out.println("\t 2. Cadastrar Veículo de Carga");
        System.out.println("\t 3. Imprimir Todos os Veículos de Passeio");
        System.out.println("\t 4. Imprimir Todos os Veículos de Carga");
        System.out.println("\t 5. Imprimir Veículo de Passeio pela Placa");
        System.out.println("\t 6. Imprimir Veículo de Carga pela Placa");
        System.out.println("\t 7. Sair do Sistema");
    }
    
    private static void cadastraPasseio() {
        passeio = new Passeio();
        
        passeio = (Passeio) cadastraVeiculo(passeio);
        passeio.setModelo(Teste.Modelos.values()[Integer.parseInt(leitura.entDados(imprimeOpcoesModelosPasseio()))].toString());
        passeio.setMarca(obterMarca(passeio.getModelo()));
        passeio.setQtdPassageiros(Integer.parseInt(leitura.entDados("\tInforme a quantidade de passageiros:")));
        
        try {
            bdVeiculos.cadastraPasseio(passeio);
        } catch (VeicExistException e) {
            System.out.println(e.getMessage());
        }
        
        if (leitura.entDados("Deseja cadastrar um novo veículo de passeio?(S/N)").equals("S"))
            cadastraPasseio();
    }
    
    private static void cadastraCarga() {
        carga = new Carga();
        
        carga = (Carga) cadastraVeiculo(carga);
        carga.setModelo(Modelos.values()[Integer.parseInt(leitura.entDados(imprimeOpcoesModelosCarga()))].toString());
        carga.setMarca(obterMarca(carga.getModelo()));
        carga.setCargaMax(Integer.parseInt(leitura.entDados("\tInforme a carga máxima:")));
        carga.setTara(Integer.parseInt(leitura.entDados("\tInforme a tara do veículo de carga:")));
        
        try {
            bdVeiculos.cadastraCarga(carga);
        } catch (VeicExistException e) {
            System.out.println(e.getMessage());
        }
        
        if (leitura.entDados("Deseja cadastrar um novo veículo de carga?(S/N)").equals("S"))
            cadastraCarga();
    }
    
    private static void imprimeVeiculos(int tipoVeiculo, String placa) {
        Veiculo[] veiculos;
        
        if (tipoVeiculo == PASSEIO)
            veiculos = bdVeiculos.getVetPasseio();
        else
            veiculos = bdVeiculos.getVetCarga();
        
        for (int idx = 0; idx < veiculos.length; idx++) {
            if (veiculos[idx] == null)
                continue;
            
            if (placa.equals("") || placa.equals(veiculos[idx].getPlaca())) {
                System.out.println("Veiculo numero " + idx + ":\n");
                System.out.println(veiculos[idx]);
                System.out.println("==================");
            }
        }
    }
    
    private static Veiculo cadastraVeiculo(Veiculo veiculo) {
        veiculo.setPlaca(leitura.entDados("\tInforme a placa do veículo:"));
        veiculo.setCor(Cores.values()[Integer.parseInt(leitura.entDados(imprimeOpcoesCores()))].toString());
        veiculo.getMotor().setPotencia(Integer.parseInt(leitura.entDados("\tInforme a potência do veículo:")));
        veiculo.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("\tInforme a quantidade de pistões do veículo:")));
        veiculo.setQtdRodas(Integer.parseInt(leitura.entDados("\tInforme a quantidade de rodas do veículo:")));
        
        try {
            veiculo.setVelocMax(Float.parseFloat(leitura.entDados("\tInforme a velocidade máxima do veículo:")));
        } catch (VelocException e) {
            System.out.println(e.getMessage());
        }
        
        return veiculo;
    }
    
    private static String imprimeOpcoesModelosPasseio() {
        return "Informe o número do modelo de veículo de passeio desejado: \n"
                        + Modelos.Clio .ordinal() + " - " + Modelos.Clio .toString() + "\n"
                        + Modelos.Logan.ordinal() + " - " + Modelos.Logan.toString() + "\n"
                        + Modelos.Uno  .ordinal() + " - " + Modelos.Uno  .toString() + "\n"
                        + Modelos.Cruze.ordinal() + " - " + Modelos.Cruze.toString();
    }
    
    private static String imprimeOpcoesModelosCarga() {
        return "Informe o número do modelo de veículo de carga desejado: \n"
                        + Modelos.Ducato  .ordinal() + " - " + Modelos.Ducato  .toString() + "\n"
                        + Modelos.Master  .ordinal() + " - " + Modelos.Master  .toString() + "\n"
                        + Modelos.Meteor  .ordinal() + " - " + Modelos.Meteor  .toString() + "\n"
                        + Modelos.Delivery.ordinal() + " - " + Modelos.Delivery.toString();         
    }
    
    private static String imprimeOpcoesCores() {
        return "Informe o número da cor desejada para seu veículo: \n"
                + Cores.Vermelho.ordinal() + " - " + Cores.Vermelho.toString() + "\n"
                + Cores.Branco  .ordinal() + " - " + Cores.Branco  .toString() + "\n"
                + Cores.Preto   .ordinal() + " - " + Cores.Preto   .toString() + "\n"
                + Cores.Azul    .ordinal() + " - " + Cores.Azul    .toString();
    }
}
