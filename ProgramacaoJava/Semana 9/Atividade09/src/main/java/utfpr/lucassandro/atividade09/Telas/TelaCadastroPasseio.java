/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import Exceptions.CampoNaoPreenchidoException;
import Exceptions.ModeloNaoExistenteException;
import Exceptions.VeicExistException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Passeio;

/**
 *
 * @author lucassandro
 */
public class TelaCadastroPasseio extends TelaCadastroVeiculo {
    private static String[] modelos = {"Clio", "Logan", "Uno", "Cruze" };
    private static JLabel lblQtdPassageiros = new JLabel("Qtd. Passageiros");
    
    private static JTextField txfQtdPassageiros = new JTextField(5);
    
    public TelaCadastroPasseio(BDVeiculos bdVeiculos) {
        super("Passeio", bdVeiculos);
        inicializaComponentes();
        super.incializaFuncionalidades();
    }
    
    protected void inicializaComponentes() {
        lblQtdPassageiros.setText("Qtd. Passageiros");
        cmbModelo = new JComboBox(modelos);        
        add(lblQtdPassageiros);
        add(txfQtdPassageiros);
        super.inicializaComponentes();
    }

    @Override
    void btnCadastrarClique(ActionEvent e) {
        try {
            camposPreenchidos();
            super.camposPreenchidos();
        } catch (CampoNaoPreenchidoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Passeio passeio = new Passeio();
        passeio = (Passeio)cadastraVeiculo(passeio);
        passeio.setQtdPassageiros(Integer.parseInt(txfQtdPassageiros.getText()));
            
        try {
            bdVeiculos.cadastraPasseio(passeio);
        } catch (VeicExistException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    protected void camposPreenchidos() throws CampoNaoPreenchidoException {
        if (txfQtdPassageiros.getText().isEmpty() || txfQtdPassageiros.getText().isBlank())
            throw new CampoNaoPreenchidoException();
    }

    @Override
    int obterMarca(int modeloSelecionado) throws ModeloNaoExistenteException {
        switch (modeloSelecionado) {
            case 0:
            case 1:
                return 1;
            
            case 2:
                return 0;
                
            case 3:
                return 2;
        }
         
        throw new ModeloNaoExistenteException();
    }

    @Override
    void cmbModeloAlterado(ActionEvent e) {
        int idx = cmbModelo.getSelectedIndex();
        
        try {
            cmbMarca.setSelectedIndex(obterMarca(idx));
        } catch (ModeloNaoExistenteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            btnLimparClique(e);
        }
    }
    
}
