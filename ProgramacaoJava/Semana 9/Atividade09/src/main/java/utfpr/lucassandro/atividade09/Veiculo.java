/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09;

import Exceptions.VelocException;

/**
 *
 * @author lucassandro
 */
public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;

    public Veiculo() {
        placa    = " ";
        marca    = " ";
        modelo   = " ";
        cor      = " ";
        velocMax = 0  ;
        qtdRodas = 0  ;
        motor    = new Motor();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public void setVelocMax(float velocMax) throws VelocException {
        if (velocMax < 80 || velocMax > 110) {
            if (this.getClass().getSimpleName().equals("Passeio"))
                this.velocMax = 100;
            else
                this.velocMax = 90;
            
            throw new VelocException();
        }
        
        this.velocMax = velocMax;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    public abstract float calcVel(float velocMax);

    @Override
    public String toString() {
        return "Placa: " + placa + "\n"
                + "Marca: " + marca + "\n"
                + "Modelo: " + modelo + "\n"
                + "Cor: " + cor + "\n"
                + "Quantidade de Rodas: " + qtdRodas + "\n"
                + motor;
    }    
}
