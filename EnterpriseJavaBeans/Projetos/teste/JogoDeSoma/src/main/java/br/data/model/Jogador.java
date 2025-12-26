/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data.model;

import lombok.Data;

/**
 *
 * @author lucassandro
 */
@Data
public class Jogador {
    private String nome;
    private int pontos;

    public Jogador() {
    }

    public Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }
}
