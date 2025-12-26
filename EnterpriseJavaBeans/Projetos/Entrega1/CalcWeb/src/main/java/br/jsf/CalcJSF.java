/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.CalcEJB;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lucassandro
 */
@Named(value = "calcJSF")
@RequestScoped
public class CalcJSF {
    @EJB
    CalcEJB calcEJB;
    
    @Getter @Setter
    private double numeroA;
    
    @Getter @Setter
    private double numeroB;
    
    @Getter
    private double resultadoSoma;
    
    @Getter
    private double resultadoSubtracao;
    
    @Getter
    private double resultadoMultiplicacao;
    
    @Getter
    private double resultadoDivisao;

    public CalcJSF() {
    }
    
    public void calcular() {
        resultadoSoma = calcEJB.somar(numeroA, numeroB);
        resultadoSubtracao = calcEJB.subtrair(numeroA, numeroB);
        resultadoMultiplicacao = calcEJB.multiplicar(numeroA, numeroB);
        resultadoDivisao = 0;
        
        try {
            if (numeroB == 0)
                throw new NumberFormatException("Divisão por zero não é permitida");
        
            resultadoDivisao = calcEJB.dividir(numeroA, numeroB);
        } catch (NumberFormatException e)  {
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Erro", e.getMessage()));
        }        
    }
    
}
