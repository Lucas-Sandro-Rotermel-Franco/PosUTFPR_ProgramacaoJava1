/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author lucassandro
 */
public class CampoNaoPreenchidoException extends Exception {

    public CampoNaoPreenchidoException() {
        super("Existem campos não preenchidos, favor validar!");
    }
    
}
