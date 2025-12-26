/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bri;

import jakarta.ejb.Remote;

/**
 *
 * @author lucassandro
 */
@Remote
public interface ICalculadora {
    public int somar(int valor1, int valor2);
}
