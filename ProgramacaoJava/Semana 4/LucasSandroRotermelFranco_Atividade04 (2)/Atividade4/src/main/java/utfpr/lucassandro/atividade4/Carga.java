/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade4;

/**
 *
 * @author lucassandro
 */
public class Carga extends Veiculo {
    private int cargaMax;
    private int tara;

    public Carga() {
        cargaMax = 0;
        tara = 0;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    } 
    
    @Override
    public float calcVel(float velocMax) {
        return velocMax * 100000;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "-----------------\n"
                + "Tipo de veiculo: Carga\n"
                + "Carga máxima: " + cargaMax + "\n"
                + "Tara: " + tara + "\n"
                + "Velocidade Maxima: " + String.format("%.1f", calcVel(getVelocMax())) + " cm/h";
    }
    
    
}
