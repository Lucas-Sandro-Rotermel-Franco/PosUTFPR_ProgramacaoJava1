/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import Exceptions.CampoNaoPreenchidoException;
import Exceptions.ModeloNaoExistenteException;
import Exceptions.VelocException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Veiculo;

/**
 *
 * @author lucassandro
 */
public abstract class TelaCadastroVeiculo extends JFrame {
    protected static String[] listaMarcas = {"Fiat", "Renault", "Chevrolet", "Volkswagen" };
    protected static String[] listaCores  = {"Vermelho", "Branco", "Preto", "Azul" };
    
    private static JLabel lblPlaca    = new JLabel("Placa");
    private static JLabel lblMarca    = new JLabel("Marca");
    private static JLabel lblModelo   = new JLabel("Modelo");
    private static JLabel lblCor      = new JLabel("Cor");
    private static JLabel lblQtdRodas = new JLabel("QtdRodas");
    private static JLabel lblVelocMax = new JLabel("VelocMax");
    private static JLabel lblQtdPist  = new JLabel("QtdPist");
    private static JLabel lblPotencia = new JLabel("Potencia");
    
    protected static JTextField txfPlaca    = new JTextField(7);
    protected static JTextField txfQtdRodas = new JTextField(2);
    protected static JTextField txfVelocMax = new JTextField(6);
    protected static JTextField txfQtdPist  = new JTextField(2);
    protected static JTextField txfPotencia = new JTextField(2);
    
    protected static JComboBox  cmbMarca  = new JComboBox(listaMarcas);
    protected static JComboBox  cmbCor    = new JComboBox(listaCores);
    protected static JComboBox  cmbModelo;
    
    protected static JButton btnCadastrar = new JButton();
    protected static JButton btnLimpar    = new JButton();
    protected static JButton btnNovo      = new JButton();
    protected static JButton btnSair      = new JButton();
    
    protected BDVeiculos bdVeiculos;
    
    public TelaCadastroVeiculo(String tipoDeVeiculo, BDVeiculos bdVeiculos) {
        this.bdVeiculos = bdVeiculos;
        setTitle("Cadastro de " + tipoDeVeiculo);
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
    }

    protected void inicializaComponentes() {
        lblPlaca   .setText("Placa: ");
        lblCor     .setText("Cor: ");
        lblMarca   .setText("Marca: ");
        lblModelo  .setText("Modelo: ");
        lblPotencia.setText("Potencia: ");
        lblQtdPist .setText("Qtd. Pistões: ");
        lblQtdRodas.setText("Qtd. Rodas: ");
        lblVelocMax.setText("Velocidade Máx.: ");
        
        cmbMarca.setEditable(false);
        cmbMarca.setEnabled(false);
        try {
            cmbMarca.setSelectedIndex(obterMarca(cmbModelo.getSelectedIndex()));
        } catch (ModeloNaoExistenteException excpt) {
            JOptionPane.showMessageDialog(null, excpt.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            cmbMarca.setSelectedIndex(0);
        }

        btnCadastrar.setText("Cadastrar");
        btnLimpar   .setText("Limpar");
        btnNovo     .setText("Novo");
        btnSair     .setText("Sair");
        
        add(lblPlaca);
        add(txfPlaca);
        add(lblMarca);
        add(cmbMarca);
        add(lblModelo);
        add(cmbModelo);
        add(lblCor);
        add(cmbCor);
        add(lblQtdRodas);
        add(txfQtdRodas);
        add(lblVelocMax);
        add(txfVelocMax);
        add(lblQtdPist);
        add(txfQtdPist);
        add(lblPotencia);
        add(txfPotencia);
        
        for (ActionListener al : btnCadastrar.getActionListeners())
            btnCadastrar.removeActionListener(al);
        
        for (ActionListener al : btnLimpar.getActionListeners())
            btnLimpar.removeActionListener(al);
        
        for (ActionListener al : btnNovo.getActionListeners())
            btnNovo.removeActionListener(al);
        
        for (ActionListener al : btnSair.getActionListeners())
            btnSair.removeActionListener(al);
        
        add(btnCadastrar);
        add(btnLimpar);
        add(btnNovo);
        add(btnSair);
    }

    protected void incializaFuncionalidades() {
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCadastrarClique(e);
            }
        });
        
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnLimparClique(e);
            }
        });
        
        btnNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNovoClique(e);
            }
        });
        
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSairClique(e);
            }
        });
        
        cmbModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmbModeloAlterado(e);
            }
        });
    }
    
    protected void btnLimparClique(ActionEvent e) {
        txfPlaca   .setText("");
        txfPotencia.setText("");
        txfQtdPist .setText("");
        txfQtdRodas.setText("");
        txfVelocMax.setText("");
        
        cmbMarca .setSelectedIndex(0);
        cmbModelo.setSelectedIndex(0);
        
        try {
            cmbMarca.setSelectedIndex(obterMarca(cmbModelo.getSelectedIndex()));
        } catch (ModeloNaoExistenteException excpt) {
            JOptionPane.showMessageDialog(null, excpt.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            cmbMarca.setSelectedIndex(0);
        }
    }
    
    private void btnNovoClique(ActionEvent e) {
        btnLimparClique(e);
    }
    
    private void btnSairClique(ActionEvent e) {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        dispose();
    }
    
    protected void camposPreenchidos() throws CampoNaoPreenchidoException {
        if (txfPlaca.getText().isEmpty() || txfPlaca.getText().isBlank())
            throw new CampoNaoPreenchidoException();
        
        if (txfPotencia.getText().isEmpty() || txfPotencia.getText().isBlank())
            throw new CampoNaoPreenchidoException();
        
        if (txfQtdPist.getText().isEmpty() || txfQtdPist.getText().isBlank())
            throw new CampoNaoPreenchidoException();
        
        if (txfQtdRodas.getText().isEmpty() || txfQtdRodas.getText().isBlank())
            throw new CampoNaoPreenchidoException();
        
        if (txfVelocMax.getText().isEmpty() || txfVelocMax.getText().isBlank())
            throw new CampoNaoPreenchidoException();
    }
    
    protected static Veiculo cadastraVeiculo(Veiculo veiculo) {
        veiculo.setPlaca(txfPlaca.getText());
        veiculo.setMarca(cmbMarca.getSelectedItem().toString());
        veiculo.setModelo(cmbModelo.getSelectedItem().toString());
        veiculo.setCor(cmbCor.getSelectedItem().toString());
        veiculo.setQtdRodas(Integer.parseInt(txfQtdRodas.getText()));
        veiculo.getMotor().setQtdPist(Integer.parseInt(txfQtdPist.getText()));
        veiculo.getMotor().setPotencia(Integer.parseInt(txfPotencia.getText()));
            
        try {
            veiculo.setVelocMax(Float.parseFloat(txfVelocMax.getText()));
        } catch (VelocException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        
        return veiculo;
    }
    
    public BDVeiculos getBDVeiculos() {
        return bdVeiculos;
    }
    
    abstract void btnCadastrarClique(ActionEvent e);

    abstract int obterMarca(int modeloSelecionado) throws ModeloNaoExistenteException;
    
    abstract void cmbModeloAlterado(ActionEvent e);
    
}
