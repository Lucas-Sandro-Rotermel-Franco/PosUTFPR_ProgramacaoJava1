/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import bri.ICalculadora;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lucassandro
 */
@Named(value = "jsfCalculadora")
@RequestScoped
public class JsfCalculadora {

    @EJB
    private ICalculadora ejbCalculadora;
    
    @Setter @Getter
    private int valorA;
    
    @Setter @Getter
    private int valorB;
    
    @Getter
    private int resultado;
    
    /**
     * Creates a new instance of JsfCalculadora
     */
    public JsfCalculadora() {
    }
    
    public void somar() {
        resultado = ejbCalculadora.somar(valorA, valorB);
    }
}
