/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package utfpr.lucassandro.atividade09;

import Exceptions.VeicExistException;
import Exceptions.VeicNaoExistException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Telas.TelaGestaoDeVeiculos;

/**
 *
 * @author lucassandro
 */
public class Teste {
    private static BDVeiculos bdVeiculos = new BDVeiculos();
    
    public static void main(String[] args) {
        TelaGestaoDeVeiculos gestVel = new TelaGestaoDeVeiculos(bdVeiculos);
        gestVel.setVisible(true);
    }
}
