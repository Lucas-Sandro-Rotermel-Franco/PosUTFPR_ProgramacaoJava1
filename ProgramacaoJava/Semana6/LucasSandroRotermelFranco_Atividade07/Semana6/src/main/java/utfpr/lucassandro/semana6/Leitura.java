/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.semana6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lucassandro
 */
public class Leitura {
    public String entDados(String rotulo) { 
        System.out.println(rotulo);
        
        InputStreamReader tec = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(tec);
        
        String ret = "";
        
        try {
            ret = buff.readLine();
        }
        catch(IOException ioe){
            System.out.println("\n Erro de sistema");
        }
        return ret;
    }
}
