/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09;

import Exceptions.VeicExistException;
import Exceptions.VeicNaoExistException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucassandro
 */
public class BDVeiculos {
    private List <Passeio> listaPasseio = new ArrayList<Passeio>();
    private List <Carga> listaCarga = new ArrayList<Carga>();

    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public void setListaPasseio(List<Passeio> listaPasseio) {
        this.listaPasseio = listaPasseio;
    }

    public List<Carga> getListaCarga() {
        return listaCarga;
    }

    public void setListaCarga(List<Carga> listaCarga) {
        this.listaCarga = listaCarga;
    }
    
    private void placaExistente(String placa) throws VeicExistException {
        for (int idx = 0; idx < listaPasseio.size(); idx++) {            
            if (listaPasseio.get(idx).getPlaca().equals(placa))
                throw new VeicExistException();
        }
        
        for (int idx = 0; idx < listaCarga.size(); idx++) {            
            if (listaCarga.get(idx).getPlaca().equals(placa))
                throw new VeicExistException();
        }
        
        return;
    }
    
    public void cadastraPasseio(Passeio passeio) throws VeicExistException {
        placaExistente(passeio.getPlaca());
        
        listaPasseio.add(passeio);
    }
    
    public void cadastraCarga(Carga carga) throws VeicExistException {
        placaExistente(carga.getPlaca());
        
        listaCarga.add(carga);
    }

    public Passeio getPasseio(String placa) throws VeicNaoExistException {
        for (int idx = 0; idx < listaPasseio.size(); ++idx) {
            if (listaPasseio.get(idx).getPlaca().equals(placa))
                return listaPasseio.get(idx);
        }
        
        throw new VeicNaoExistException();
    }

    public Carga getCarga(String placa) throws VeicNaoExistException {
        for (int idx = 0; idx < listaCarga.size(); ++idx) {
            if (listaCarga.get(idx).getPlaca().equals(placa))
                return listaCarga.get(idx);
        }
        
        throw new VeicNaoExistException();
    }
    
    
}
