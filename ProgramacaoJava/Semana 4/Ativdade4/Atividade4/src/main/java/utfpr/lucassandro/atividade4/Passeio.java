/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade4;

/**
 *
 * @author lucassandro
 */
public class Passeio extends Veiculo {
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
                + "Tipo de veiculo: Passeio\n"
                + "Quantidade de passageiros: " + qtdPassageiros + "\n"
                + "Velocidade Maxima: " + String.format("%.1f", calcVel(getVelocMax())) + " m/h";
    }
    
}
