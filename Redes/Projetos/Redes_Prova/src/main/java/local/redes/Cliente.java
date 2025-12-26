/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.redes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucassandro
 */
public class Cliente {
    public static long ZERO = 0;
    public static long A = 30;
    public static long B = 3;
    
    public static void main(String[] args) {
        try {
            Calculadora stub = (Calculadora) Naming.lookup("rmi://127.0.0.1/calculadoraRMI");
            
            System.out.println("-----Invocando métodos remotos-----");
            
            System.out.println("Soma: " + A + " + " + B + " = " + stub.add(A, B));
            System.out.println("Subtração: " + A + " - " + B + " = " + stub.sub(A, B));
            System.out.println("Multiplicação: " + A + " * " + B + " = " + stub.mul(A, B));
            System.out.println("Divisão: " + A + " / " + B + " = " + stub.div(A, B));
            try {
                System.out.println("Divisão por zero: " + A + " / " + ZERO + " = " + stub.div(A, ZERO));
            } catch (Exception e) {
                System.out.println("Exceção obtida: " + e.getMessage());
            }
            
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
