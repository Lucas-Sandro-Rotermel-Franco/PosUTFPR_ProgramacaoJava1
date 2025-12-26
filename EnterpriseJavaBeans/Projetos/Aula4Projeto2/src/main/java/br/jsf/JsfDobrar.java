/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbDobrarLocal;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 *
 * @author lucassandro
 */
@Named(value = "jsfDobrar")
@RequestScoped
public class JsfDobrar {

    @EJB
    private EjbDobrarLocal ejbDobrar;
    
    private int valor;
    private int resultado;

    /**
     * Creates a new instance of JsfDobrar
     */
    public JsfDobrar() {
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    public void  dobrar() {
        this.resultado = ejbDobrar.dobrar(valor);
    }
}
