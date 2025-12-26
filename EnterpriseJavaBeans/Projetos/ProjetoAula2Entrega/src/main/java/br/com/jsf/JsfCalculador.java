package br.com.jsf;

import br.com.ejb.EjbCalculadora;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

/**
 *
 * @author lucassandro
 */
@Named(value = "jsfCalculador")
@RequestScoped
public class JsfCalculador {
    
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "java/Fila")
    private Queue fila;
    
    @EJB
    EjbCalculadora ejbCalculadora;
    
    private int numero;
    
    /**
     * Creates a new instance of JsfCalculador
     */
    public JsfCalculador() {
    }
    
    public void send() {
        context.createProducer().send(fila, getQuadrado());
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getNumero() {
        return numero;
    }

    public int getQuadrado() {
        return ejbCalculadora.calculaQuadrado(numero);
    }    
}
