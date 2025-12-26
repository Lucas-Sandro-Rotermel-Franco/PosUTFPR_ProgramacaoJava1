/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import br.data.crud.CrudProduto;
import br.data.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import java.util.ArrayList;

/**
 *
 * @author lucassandro
 */
@Stateless
@LocalBean
public class EjbProduto {

    public ArrayList<Produto> getAll() {
        return new CrudProduto().getAll();
    }
}
