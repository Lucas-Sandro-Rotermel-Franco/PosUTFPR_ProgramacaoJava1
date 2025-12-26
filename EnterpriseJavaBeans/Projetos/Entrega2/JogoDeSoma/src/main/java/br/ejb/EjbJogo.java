/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatefulEjbClass.java to edit this template
 */
package br.ejb;

import jakarta.ejb.Stateful;
import jakarta.ejb.LocalBean;

/**
 *
 * @author lucassandro
 */
@Stateful
@LocalBean
public class EjbJogo {

    public boolean validaResposta(int resposta, int gabarito) {
        return resposta == gabarito;
    }
}
