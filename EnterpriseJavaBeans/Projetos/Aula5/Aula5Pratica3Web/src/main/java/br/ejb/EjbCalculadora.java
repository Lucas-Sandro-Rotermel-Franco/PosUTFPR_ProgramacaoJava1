/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author lucassandro
 */
@Stateless
@LocalBean
public class EjbCalculadora implements bri.ICalculadora {

    @Override
    public int somar(int valor1, int valor2) {
        return valor1 + valor2;
    }

}
