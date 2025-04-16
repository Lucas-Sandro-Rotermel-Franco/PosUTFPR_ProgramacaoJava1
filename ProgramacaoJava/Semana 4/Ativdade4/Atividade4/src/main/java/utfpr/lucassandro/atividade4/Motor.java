/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade4;

/**
 *
 * @author lucassandro
 */
public class Motor {
    private int qtdPist;
    private int potencia;

    public Motor() {
        qtdPist  = 0;
        potencia = 0;
    }

    public int getQtdPist() {
        return qtdPist;
    }

    public void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "-----------------\n"
                + "Motor:\n"
                + "  Quantidade de Pistoes: " + qtdPist + "\n"
                + "  Potencia: " + potencia + "\n";
    }    
}
