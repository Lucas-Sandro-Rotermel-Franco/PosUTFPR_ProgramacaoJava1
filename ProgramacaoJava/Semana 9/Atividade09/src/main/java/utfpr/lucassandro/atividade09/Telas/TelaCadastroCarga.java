/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import Exceptions.CampoNaoPreenchidoException;
import Exceptions.ModeloNaoExistenteException;
import Exceptions.VeicExistException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Carga;

/**
 *
 * @author lucassandro
 */
public class TelaCadastroCarga extends TelaCadastroVeiculo {
    private static String[] modelos = { "Ducato", "Master", "Meteor", "Delivery" };
    
    private static JLabel lblTara     = new JLabel("Tara");
    private static JLabel lblCargaMax = new JLabel("Carga Máx.");
    
    private static JTextField txfTara     = new JTextField(5);
    private static JTextField txfCargaMax = new JTextField(5);

    public TelaCadastroCarga(BDVeiculos bdVeiculos) {
        super("Carga", bdVeiculos);
        inicializaComponentes();
        super.inicializaFuncionalidades();
    }
    
    protected void inicializaComponentes() {
        lblTara    .setText("Tara: ");
        lblCargaMax.setText("Carga Máx.: ");
        
        cmbModelo = new JComboBox(modelos);
        
        add(lblTara);
        add(txfTara);
        add(lblCargaMax);
        add(txfCargaMax);
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
        
        Carga carga = new Carga();
        carga = (Carga)cadastraVeiculo(carga);
        carga.setTara(Integer.parseInt(txfTara.getText()));
        carga.setCargaMax(Integer.parseInt(txfCargaMax.getText()));
        
        try {
            bdVeiculos.cadastraCarga(carga);
        } catch (VeicExistException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    protected void camposPreenchidos() throws CampoNaoPreenchidoException {
        if (txfCargaMax.getText().isEmpty() || txfCargaMax.getText().isBlank())
            throw new CampoNaoPreenchidoException();
        
        if (txfTara.getText().isEmpty() || txfTara.getText().isBlank())
            throw new CampoNaoPreenchidoException();
    }

    @Override
    int obterMarca(int modeloSelecionado) throws ModeloNaoExistenteException {
        switch (modeloSelecionado) {
            case 0:
                return 0;
            
            case 1:
                return 1;
            
            case 2:
            case 3:
                return 3;
        }
        
        throw new ModeloNaoExistenteException();
    }
    
    @Override
    void limpaCamposFilhos() {
        txfTara    .setText("");
        txfCargaMax.setText("");
    }

    @Override
    void btnNovoClique(ActionEvent e) {
        txfTara.requestFocusInWindow();
        btnLimparClique(e);
    }
    
}
