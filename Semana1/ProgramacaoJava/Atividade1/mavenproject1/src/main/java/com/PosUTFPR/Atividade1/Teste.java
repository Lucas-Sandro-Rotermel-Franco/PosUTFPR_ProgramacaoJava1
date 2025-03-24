/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.PosUTFPR.Atividade1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lucassandro
 */
public class Teste {
    enum Modelos {
        Clio,
        Logan,
        Uno,
        Cruze
    }
    
    enum Marcas {
        Fiat,
        Renault,
        Chevrolet
    }
    
    enum Cores {
        Vermelho,
        Branco,
        Preto,
        Azul
    }
    
    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();
        
        Veiculo veiculo = new Veiculo();
        Motor motor = new Motor();
        
        { //Veiculo 1
            veiculo.setModelo(Modelos.Clio.toString());
            veiculo.setCor(Cores.Preto.toString());
            veiculo.setMarca(obterMarca(veiculo.getModelo()));
            veiculo.setPlaca("EJKO3R32");
            veiculo.setQtdRodas(4);
            veiculo.setVelocMax(124.5f);
        
            motor.setPotencia(8);
            motor.setQtdPist(4);
            veiculo.setMotor(motor);
        
            veiculos.add(veiculo);
        }
        
        veiculo = new Veiculo();
        motor = new Motor();
        
        { //Veiculo 2
            veiculo.setModelo(Modelos.Uno.toString());
            veiculo.setCor(Cores.Vermelho.toString());
            veiculo.setMarca(obterMarca(veiculo.getModelo()));
            veiculo.setPlaca("JIEK7O93");
            veiculo.setQtdRodas(4);
            veiculo.setVelocMax(8001.5f);
        
            motor.setPotencia(140);
            motor.setQtdPist(8);
            veiculo.setMotor(motor);
        
            veiculos.add(veiculo);
        }
        
        veiculo = new Veiculo();
        motor = new Motor();
        
        { //Veiculo 3
            veiculo.setModelo(Modelos.Logan.toString());
            veiculo.setCor(Cores.Branco.toString());
            veiculo.setMarca(obterMarca(veiculo.getModelo()));
            veiculo.setPlaca("MLP4E75");
            veiculo.setQtdRodas(4);
            veiculo.setVelocMax(165.32f);
        
            motor.setPotencia(250);
            motor.setQtdPist(4);
            veiculo.setMotor(motor);
        
            veiculos.add(veiculo);
        }
        
        veiculo = new Veiculo();
        motor = new Motor();
        
        { //Veiculo 4
            veiculo.setModelo(Modelos.Cruze.toString());
            veiculo.setCor(Cores.Vermelho.toString());
            veiculo.setMarca(obterMarca(veiculo.getModelo()));
            veiculo.setPlaca("KAOE2OE03");
            veiculo.setQtdRodas(4);
            veiculo.setVelocMax(12.3f);
        
            motor.setPotencia(34);
            motor.setQtdPist(2);
            veiculo.setMotor(motor);
        
            veiculos.add(veiculo);
        }
        
        veiculo = new Veiculo();
        motor = new Motor();
        
        { //Veiculo 5
            veiculo.setModelo(Modelos.Uno.toString());
            veiculo.setCor(Cores.Branco.toString());
            veiculo.setMarca(obterMarca(veiculo.getModelo()));
            veiculo.setPlaca("KOEO013KO");
            veiculo.setQtdRodas(4);
            veiculo.setVelocMax(394.2f);
        
            motor.setPotencia(140);
            motor.setQtdPist(8);
            veiculo.setMotor(motor);
        
            veiculos.add(veiculo);
        }
        
        for (int idx = 0; idx < veiculos.size(); ++idx) {
            System.out.println("**********************************************");
            System.out.println("Veiculo " + (idx +  1));
            System.out.println(veiculos.get(idx));
        }
    }
    
    private static String obterMarca(String modelo) {
        if (modelo.equals(Modelos.Clio.toString()) || modelo.equals(Modelos.Logan.toString()))
            return Marcas.Renault.toString();
        
        if (modelo.equals(Modelos.Uno.toString()))
            return Marcas.Fiat.toString();
        
        if (modelo.equals(Modelos.Cruze.toString()))
            return Marcas.Chevrolet.toString();
        
        return " ";
    } 
}
