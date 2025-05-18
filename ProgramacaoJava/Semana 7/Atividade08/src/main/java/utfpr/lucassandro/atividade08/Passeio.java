/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade08;

import java.lang.reflect.Method;

/**
 *
 * @author lucassandro
 */
public final class Passeio extends Veiculo implements Calcular{
    private int qtdPassageiros;

    public Passeio() {
        this.qtdPassageiros = 0;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }
    
    @Override
    public float calcVel(float velocMax) {
        return velocMax * 1000;
    }

    @Override
    public String toString() {
        return super.toString()
                + "-----------------\n"
                + "Resultado da soma da quantidade de letras nos atributos String: " + calcular() + "\n"
                + "Velocidade Maxima: " + String.format("%.1f", calcVel(getVelocMax())) + " m/h\n"
                + "Tipo de veiculo: Passeio\n"
                + "Quantidade de passageiros: " + qtdPassageiros;
    }

    @Override
    public int calcular() {
        int somaLetras = 0;
        
        /*i. Na classe Passeio: retornará a soma das quantidades de LETRAS
existentes em todos os atributos do tipo String;*/
        somaLetras += this.getPlaca().replaceAll("[0-9]", "").length();
        somaLetras += this.getModelo().replaceAll("[0-9]", "").length();
        somaLetras += this.getCor().replaceAll("[0-9]", "").length();
        somaLetras += this.getMarca().replaceAll("[0-9]", "").length();
        
        return somaLetras;
    }
    
}
