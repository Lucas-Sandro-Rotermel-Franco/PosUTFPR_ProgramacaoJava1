/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.data.model.Jogador;
import br.ejb.EjbJogadores;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lucassandro
 */
@Named(value = "jsfJogador")
@SessionScoped
public class jsfJogador implements Serializable {

    @EJB
    private EjbJogadores ejbJogadores;

    @Getter
    @Setter
    private String nome;

    /**
     * Creates a new instance of jsfJogador
     */
    public jsfJogador() {
    }

    public void add() {
        ejbJogadores.add(nome);
    }

    public ArrayList<Jogador> getAll() {
        return ejbJogadores.getAll();
    }

    public EjbJogadores getEjbJogadores() {
        return ejbJogadores;
    }

}
