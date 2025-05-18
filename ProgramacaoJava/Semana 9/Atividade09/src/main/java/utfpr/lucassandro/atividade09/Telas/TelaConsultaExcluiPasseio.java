/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import Exceptions.CampoNaoPreenchidoException;
import Exceptions.VeicNaoExistException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Passeio;

/**
 *
 * @author lucassandro
 */
public class TelaConsultaExcluiPasseio extends TelaConsultaExcluiVeiculo{
    
    private static JLabel lblQtdPassageiros = new JLabel("Qtd. Passageiros");
    
    private static JTextField txfQtdPassageiros = new JTextField(2);
    
    public TelaConsultaExcluiPasseio(BDVeiculos bdVeiculos) {
        super(bdVeiculos);
    }

    @Override
    void inicializaComponentesFilho() {
        lblQtdPassageiros.setText("Qtd. Passageiros: ");
        
        txfQtdPassageiros.setEnabled(false);
        
        add(lblQtdPassageiros);
        add(txfQtdPassageiros);
    }

    @Override
    void btnConsultarClique(ActionEvent e) {
        try {
            campoPreenchido();
            Passeio passeio = bdVeiculos.getPasseio(txfPlaca.getText());
            
            txfQtdPassageiros.setText(Integer.toString(passeio.getQtdPassageiros()));
            preencheCampos(passeio);
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
            bdVeiculos.getListaPasseio().remove(bdVeiculos.getPasseio(txfPlaca.getText()));
            txfQtdPassageiros.setText("");
            super.limpaCampos();
        } catch (CampoNaoPreenchidoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (VeicNaoExistException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }   
}
