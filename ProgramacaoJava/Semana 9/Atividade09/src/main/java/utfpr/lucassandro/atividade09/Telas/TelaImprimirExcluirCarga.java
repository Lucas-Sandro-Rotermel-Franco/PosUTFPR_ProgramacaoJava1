/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Carga;

/**
 *
 * @author lucassandro
 */
public class TelaImprimirExcluirCarga extends TelaImprimirExcluirVeiculo{

    public TelaImprimirExcluirCarga(BDVeiculos bdVeiculos) {
        super(bdVeiculos);
    }

    @Override
    void inicializaComponentesFilho() {
        modeloTabela.addColumn("Tara");
        modeloTabela.addColumn("Carga Máx.");
    }

    @Override
    void btnExcluirClique(ActionEvent e) {
        limpaTabela();
        bdVeiculos.setListaCarga(new ArrayList<Carga>());
    }

    @Override
    void btnImprimirClique(ActionEvent e) {
        limpaTabela();
        for (Carga carga : bdVeiculos.getListaCarga()) {
            modeloTabela.addRow(new Object[]{ carga.getPlaca(), carga.getMarca(), carga.getModelo(), carga.getCor(), 
                                              carga.getQtdRodas(), carga.getVelocMax(), carga.getMotor().getQtdPist(),
                                              carga.getMotor().getPotencia(), carga.getTara(), carga.getCargaMax() });
        }
    }
    
}
