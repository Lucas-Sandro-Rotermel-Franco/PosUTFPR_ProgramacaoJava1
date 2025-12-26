/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.redes;

/**
 *
 * @author lucassandro
 */
public interface Calculadora extends java.rmi.Remote {

public long add(long a, long b) throws java.rmi.RemoteException;

public long sub(long a, long b) throws java.rmi.RemoteException;

public long mul(long a, long b) throws java.rmi.RemoteException;

public long div(long a, long b) throws java.rmi.RemoteException;

}
