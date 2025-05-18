/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade08;

/**
 *
 * @author lucassandro
 */
public final class Carga extends Veiculo implements Calcular{
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
                + "Resultado da soma dos atributos numéricos: " + calcular() + "\n"
                + "Velocidade Maxima: " + String.format("%.1f", calcVel(getVelocMax())) + " cm/h\n"
                + "Tipo de veiculo: Carga\n"
                + "Carga máxima: " + cargaMax + "\n"
                + "Tara: " + tara;
    }

    @Override
    public int calcular() {
        int somaValores = 0;
        
        /*ii. Na classe Carga: retornará a soma de todos os valores contidos nos
atributos numéricos*/
        somaValores += this.getCargaMax();
        somaValores += this.getQtdRodas();
        somaValores += this.getTara();
        somaValores += this.getMotor().getPotencia();
        somaValores += this.getMotor().getQtdPist();
        
        return somaValores;
    }
    
    
}
