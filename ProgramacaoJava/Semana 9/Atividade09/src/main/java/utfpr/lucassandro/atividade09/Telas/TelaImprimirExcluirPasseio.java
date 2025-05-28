/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Passeio;

/**
 *
 * @author lucassandro
 */
public class TelaImprimirExcluirPasseio extends TelaImprimirExcluirVeiculo {

    public TelaImprimirExcluirPasseio(BDVeiculos bdVeiculos) {
        super(bdVeiculos);
    }

    @Override
    void inicializaComponentesFilho() {
        modeloTabela.addColumn("Qtd. Passag.");
    }

    @Override
    void btnExcluirClique(ActionEvent e) {
        limpaTabela();
        bdVeiculos.setListaPasseio(new ArrayList<Passeio>());
    }

    @Override
    void btnImprimirClique(ActionEvent e) {
        limpaTabela();
        for (Passeio passeio : bdVeiculos.getListaPasseio()) {
            modeloTabela.addRow(new Object[]{passeio.getPlaca(), passeio.getMarca(), passeio.getModelo(), passeio.getCor(), 
                                             passeio.getQtdRodas(), passeio.getVelocMax(), passeio.getMotor().getQtdPist(),
                                             passeio.getMotor().getPotencia(), passeio.getQtdPassageiros()});
        }
    }
    
}
