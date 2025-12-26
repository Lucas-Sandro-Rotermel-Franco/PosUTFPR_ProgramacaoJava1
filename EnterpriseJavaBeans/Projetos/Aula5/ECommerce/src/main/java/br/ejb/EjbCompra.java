/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatefulEjbClass.java to edit this template
 */
package br.ejb;

import br.data.model.ItemCompra;
import br.data.model.Produto;
import jakarta.ejb.Stateful;
import jakarta.ejb.LocalBean;
import java.util.ArrayList;

/**
 *
 * @author lucassandro
 */
@Stateful
@LocalBean
public class EjbCompra {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private ArrayList<ItemCompra> lCompra;

    public EjbCompra() {
        lCompra = new ArrayList<>();
    }
    
    public void add(Produto produto) {
        boolean achou = false;
        
        for (ItemCompra itemCompra : lCompra) {
            if (itemCompra.getProduto().getCodigo() == produto.getCodigo()) {
                itemCompra.setQuantidade(itemCompra.getQuantidade()+1);
                achou = true;
                break;
            }
        }
        
        if (!achou) {
            lCompra.add(new ItemCompra(produto, 1));
        }
    }
    
    public ArrayList<ItemCompra> getAll() {
        return lCompra;
    }
    
    
}
