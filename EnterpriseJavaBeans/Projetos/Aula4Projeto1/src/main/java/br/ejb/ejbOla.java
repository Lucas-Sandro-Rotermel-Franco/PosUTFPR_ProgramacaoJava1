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
public class ejbOla {
    
    public String getOla() {
        return "Olá meu primeiro projeto EJB com JSF";
    }
}
