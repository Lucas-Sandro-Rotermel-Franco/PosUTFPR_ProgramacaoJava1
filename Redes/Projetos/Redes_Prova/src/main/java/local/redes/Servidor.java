/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.redes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucassandro
 */
public class Servidor extends UnicastRemoteObject implements Calculadora {

    public Servidor() throws RemoteException {
        super();
    }
    
    @Override
    public long add(long a, long b) throws RemoteException {
        return a + b;
    }

    @Override
    public long sub(long a, long b) throws RemoteException {
        return a - b;
    }

    @Override
    public long mul(long a, long b) throws RemoteException {
        return a * b;
    }

    @Override
    public long div(long a, long b) throws RemoteException {
        if (b == 0) {
            System.out.println("Não permitido divisão por zero!");
            throw new RemoteException("Divisão por zero não é permitida!");
        }
        
        return a / b;
    }
    
    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor();
            Registry registro = LocateRegistry.createRegistry(1099);
            Naming.rebind("calculadoraRMI", servidor);
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
