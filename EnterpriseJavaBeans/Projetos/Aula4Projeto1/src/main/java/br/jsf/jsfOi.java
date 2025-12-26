package br.jsf;

import br.ejb.ejbOla;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 *
 * @author lucassandro
 */
@Named(value = "jsfOi")
@RequestScoped
public class jsfOi {

    @EJB
    private ejbOla ejb;
    
    public jsfOi() {
    }
    
    public String getOla() {
        return ejb.getOla();
    }
    
}
