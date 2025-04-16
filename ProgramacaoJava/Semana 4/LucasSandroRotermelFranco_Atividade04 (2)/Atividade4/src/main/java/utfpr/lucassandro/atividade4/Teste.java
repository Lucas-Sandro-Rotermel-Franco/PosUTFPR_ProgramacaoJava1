/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package utfpr.lucassandro.atividade4;

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
    
    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();
        
        Passeio passeio = new Passeio();
        
        { //Passeio 1
            passeio.setModelo(Modelos.Clio.toString());
            passeio.setCor(Cores.Preto.toString());
            passeio.setMarca(obterMarca(passeio.getModelo()));
            passeio.setPlaca("EJKO3R32");
            passeio.setQtdRodas(4);
            passeio.setVelocMax(124.5f);
        
            passeio.getMotor().setPotencia(8);
            passeio.getMotor().setQtdPist(4);
            
            passeio.setQtdPassageiros(5);
        
            veiculos.add(passeio);
        }
        
        Carga carga = new Carga();
        
        { //Carga 1
            carga.setModelo(Modelos.Delivery.toString());
            carga.setCor(Cores.Azul.toString());
            carga.setMarca(obterMarca(carga.getModelo()));
            carga.setPlaca("KOP9E75");
            carga.setQtdRodas(4);
            carga.setVelocMax(147f);
            
            carga.getMotor().setPotencia(156);
            carga.getMotor().setQtdPist(4);
            
            carga.setCargaMax(4600);
            carga.setTara(5000);
            
            veiculos.add(carga);
        }
        
        passeio = new Passeio();
        
        { //Passeio 2
            passeio.setModelo(Modelos.Uno.toString());
            passeio.setCor(Cores.Vermelho.toString());
            passeio.setMarca(obterMarca(passeio.getModelo()));
            passeio.setPlaca("JIEK7O93");
            passeio.setQtdRodas(4);
            passeio.setVelocMax(8001.5f);
        
            passeio.getMotor().setPotencia(140);
            passeio.getMotor().setQtdPist(8);
            
            passeio.setQtdPassageiros(4);
        
            veiculos.add(passeio);
        }
        
        carga = new Carga();
        
        { //Carga 2
            carga.setModelo(Modelos.Master.toString());
            carga.setCor(Cores.Branco.toString());
            carga.setMarca(obterMarca(carga.getModelo()));
            carga.setPlaca("TDI8A12");
            carga.setQtdRodas(4);
            carga.setVelocMax(152f);
            
            carga.getMotor().setPotencia(150);
            carga.getMotor().setQtdPist(4);
            
            carga.setCargaMax(1392);
            carga.setTara(3500);
            
            veiculos.add(carga);
        }
        
        passeio = new Passeio();
        
        { //Passeio 3
            passeio.setModelo(Modelos.Logan.toString());
            passeio.setCor(Cores.Branco.toString());
            passeio.setMarca(obterMarca(passeio.getModelo()));
            passeio.setPlaca("MLP4E75");
            passeio.setQtdRodas(4);
            passeio.setVelocMax(165.32f);
        
            passeio.getMotor().setPotencia(250);
            passeio.getMotor().setQtdPist(4);
        
            veiculos.add(passeio);
        }
        
        carga = new Carga();
        
        { //Carga 3
            carga.setModelo(Modelos.Ducato.toString());
            carga.setCor(Cores.Vermelho.toString());
            carga.setMarca(obterMarca(carga.getModelo()));
            carga.setPlaca("JNR8I20");
            carga.setQtdRodas(4);
            carga.setVelocMax(147f);
            
            carga.getMotor().setPotencia(130);
            carga.getMotor().setQtdPist(4);
            
            carga.setCargaMax(1329);
            carga.setTara(2171);
            
            veiculos.add(carga);
        }
        
        passeio = new Passeio();
        
        { //Passeio 4
            passeio.setModelo(Modelos.Cruze.toString());
            passeio.setCor(Cores.Vermelho.toString());
            passeio.setMarca(obterMarca(passeio.getModelo()));
            passeio.setPlaca("KAOE2OE03");
            passeio.setQtdRodas(4);
            passeio.setVelocMax(12.3f);
        
            passeio.getMotor().setPotencia(34);
            passeio.getMotor().setQtdPist(2);
        
            veiculos.add(passeio);
        }
        
        carga = new Carga();
        
        { //Carga 4
            carga.setModelo(Modelos.Meteor.toString());
            carga.setCor(Cores.Preto.toString());
            carga.setMarca(obterMarca(carga.getModelo()));
            carga.setPlaca("IEJ4K02");
            carga.setQtdRodas(10);
            carga.setVelocMax(120f);
            
            carga.getMotor().setPotencia(475);
            carga.getMotor().setQtdPist(6);
            
            carga.setCargaMax(28000);
            carga.setTara(9426);
            
            veiculos.add(carga);
        }
        
        passeio = new Passeio();
        
        { //Passeio 5
            passeio.setModelo(Modelos.Uno.toString());
            passeio.setCor(Cores.Branco.toString());
            passeio.setMarca(obterMarca(passeio.getModelo()));
            passeio.setPlaca("KOEO013KO");
            passeio.setQtdRodas(4);
            passeio.setVelocMax(394.2f);
        
            passeio.getMotor().setPotencia(140);
            passeio.getMotor().setQtdPist(8);
        
            veiculos.add(passeio);
        }
        
        carga = new Carga();
        
        { //Carga 5
            carga.setModelo(Modelos.Ducato.toString());
            carga.setCor(Cores.Branco.toString());
            carga.setMarca(obterMarca(carga.getModelo()));
            carga.setPlaca("EQH4HD56");
            carga.setQtdRodas(4);
            carga.setVelocMax(147f);
            
            carga.getMotor().setPotencia(130);
            carga.getMotor().setQtdPist(4);
            
            carga.setCargaMax(1329);
            carga.setTara(2171);
            
            veiculos.add(carga);
        }
        
        for (int idx = 0; idx < veiculos.size(); ++idx) {
            System.out.println("**********************************************");
            System.out.println("Veiculo " + (idx +  1));
            System.out.println(veiculos.get(idx));
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
}
