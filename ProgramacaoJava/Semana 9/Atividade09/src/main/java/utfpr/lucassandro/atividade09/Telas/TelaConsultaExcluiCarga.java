/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import Exceptions.CampoNaoPreenchidoException;
import Exceptions.VeicNaoExistException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Carga;

/**
 *
 * @author lucassandro
 */
public class TelaConsultaExcluiCarga extends TelaConsultaExcluiVeiculo{
    private static JLabel lblTara     = new JLabel("Tara");
    private static JLabel lblCargaMax = new JLabel("Carga Máx.");
    
    private static JTextField txfTara     = new JTextField(5);
    private static JTextField txfCargaMax = new JTextField(5);
    
    public TelaConsultaExcluiCarga(BDVeiculos bdVeiculos) {
        super(bdVeiculos);
    }

    @Override
    void inicializaComponentesFilho() {
        lblTara    .setText("Tara: ");
        lblCargaMax.setText("Carga Máx.: ");
        
        txfTara    .setEnabled(false);
        txfCargaMax.setEnabled(false);
        
        add(lblTara);
        add(txfTara);
        add(lblCargaMax);
        add(txfCargaMax);
    }

    @Override
    void btnConsultarClique(ActionEvent e) {
        try {
            campoPreenchido();
            Carga carga = bdVeiculos.getCarga(txfPlaca.getText());
            
            txfTara    .setText(Integer.toString(carga.getTara()));
            txfCargaMax.setText(Integer.toString(carga.getCargaMax()));
            preencheCampos(carga);
        } catch (CampoNaoPreenchidoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (VeicNaoExistException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    @Override
    void btnExcluirClique(ActionEvent e) {
        try {
            campoPreenchido();
            bdVeiculos.getListaCarga().remove(bdVeiculos.getCarga(txfPlaca.getText()));
            txfTara    .setText("");
            txfCargaMax.setText("");
            limpaCampos();
        } catch (CampoNaoPreenchidoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (VeicNaoExistException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
}
