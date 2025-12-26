/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bri;

import jakarta.ejb.Remote;

/**
 *
 * @author lucassandro
 */
@Remote
public interface CalcInterface {
    public double somar(double a, double b);
    public double subtrair(double a, double b);
    public double multiplicar(double a, double b);
    public double dividir(double a, double b);
}
