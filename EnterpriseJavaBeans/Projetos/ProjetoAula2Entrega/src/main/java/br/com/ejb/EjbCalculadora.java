/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SingletonEjbClass.java to edit this template
 */
package br.com.ejb;

import jakarta.ejb.Singleton;
import jakarta.ejb.LocalBean;

/**
 *
 * @author lucassandro
 */
@Singleton
@LocalBean
public class EjbCalculadora {
    public int calculaQuadrado(int numero) {
        return numero * numero;
    }
}
