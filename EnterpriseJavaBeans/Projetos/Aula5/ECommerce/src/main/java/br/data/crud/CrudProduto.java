/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data.crud;

import br.data.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author lucassandro
 */
public class CrudProduto {
    
    public ArrayList<Produto> getAll() {
        ArrayList<Produto> lProd = new ArrayList<>();
        lProd.add(new Produto(1, "Computador"));
        lProd.add(new Produto(2, "Mouse"));
        lProd.add(new Produto(3, "Teclado"));
        lProd.add(new Produto(4, "WebCam"));
        lProd.add(new Produto(5, "Fone"));
        
        return lProd;
    }
}
