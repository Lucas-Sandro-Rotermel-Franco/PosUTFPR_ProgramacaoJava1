/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatefulEjbClass.java to edit this template
 */
package br.ejb;

import br.data.model.Jogador;
import jakarta.ejb.Stateful;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author lucassandro
 */
@Singleton
@LocalBean
public class EjbJogadores {
    private ArrayList<Jogador> lJogador;

    public EjbJogadores() {
        lJogador = new ArrayList<>();
    }
    
    public void add(String nome) {
        boolean achou = false;
        for (Jogador jogador : lJogador) {
            if (jogador.getNome().equals(nome)) {
                achou = true;
                break;
            }
        }
        
        if (!achou) {
            lJogador.add(new Jogador(nome, 0));
        }
    }

    public ArrayList<Jogador> getAll() {
        lJogador.sort(Comparator.comparing(Jogador::getPontos).reversed());
        return lJogador;
    }

    public Jogador obtemMelhorJogador() {
        ArrayList<Jogador> ranking = getAll();
        if (ranking.isEmpty()) {
            return null;
        }
        return ranking.get(0);
    }
}
