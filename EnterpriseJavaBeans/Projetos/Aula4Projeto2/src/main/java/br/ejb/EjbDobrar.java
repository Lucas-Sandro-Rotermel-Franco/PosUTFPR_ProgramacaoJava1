/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import jakarta.ejb.Stateless;

/**
 *
 * @author lucassandro
 */
@Stateless
public class EjbDobrar implements EjbDobrarLocal {

    public int dobrar(int valor) {
        return valor * 2;
    }
}
