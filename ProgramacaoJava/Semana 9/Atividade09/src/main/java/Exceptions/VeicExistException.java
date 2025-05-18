/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author lucassandro
 */
public class VeicExistException extends Exception {
    
    public VeicExistException() {
        super("Já existe um veículo com esta placa");
    }
    
}
