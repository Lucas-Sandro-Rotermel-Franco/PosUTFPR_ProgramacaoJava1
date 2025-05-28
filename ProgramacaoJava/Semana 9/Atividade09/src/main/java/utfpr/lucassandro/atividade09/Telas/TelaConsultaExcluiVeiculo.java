/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import Exceptions.CampoNaoPreenchidoException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Veiculo;

/**
 *
 * @author lucassandro
 */
public abstract class TelaConsultaExcluiVeiculo extends JFrame {
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
    protected static JTextField txfMarca    = new JTextField(10);
    protected static JTextField txfModelo   = new JTextField(10);
    protected static JTextField txfCor      = new JTextField(10);
    
    protected static JButton btnConsultar = new JButton();
    protected static JButton btnExcluir   = new JButton();
    protected static JButton btnSair      = new JButton();
    
    protected BDVeiculos bdVeiculos;
    
    public TelaConsultaExcluiVeiculo(BDVeiculos bdVeiculos) {
        this.bdVeiculos = bdVeiculos;
        setTitle("Consultar/Excluir pela placa");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        inicializaComponentes();
        inicializaFuncionalidades();
    }

    private void inicializaComponentes() {
        lblPlaca.setText("Informe a placa: ");
        lblPlaca.setForeground(Color.red);
        add(lblPlaca);
        add(txfPlaca);
        
        lblCor     .setText("Cor: ");
        lblMarca   .setText("Marca: ");
        lblModelo  .setText("Modelo: ");
        lblPotencia.setText("Potencia: ");
        lblQtdPist .setText("Qtd. Pistões: ");
        lblQtdRodas.setText("Qtd. Rodas: ");
        lblVelocMax.setText("Velocidade Máx.: ");
        
        txfCor     .setEnabled(false);
        txfMarca   .setEnabled(false);
        txfModelo  .setEnabled(false);
        txfPotencia.setEnabled(false);
        txfQtdPist .setEnabled(false);
        txfQtdRodas.setEnabled(false);
        txfVelocMax.setEnabled(false);
        
        btnConsultar.setText("Consultar");
        btnConsultar.setBackground(Color.yellow);
        btnConsultar.setForeground(Color.red);
        
        btnExcluir.setText("Excluir");
        btnExcluir.setBackground(Color.yellow);
        btnExcluir.setForeground(Color.red);
        
        btnSair.setText("Sair");
        
        for (ActionListener al : btnSair.getActionListeners())
            btnSair.removeActionListener(al);
        
        for (ActionListener al : btnConsultar.getActionListeners())
            btnConsultar.removeActionListener(al);
        
        for (ActionListener al : btnExcluir.getActionListeners())
            btnExcluir.removeActionListener(al);
        
        inicializaComponentesFilho();
        
        add(lblMarca);
        add(txfMarca);
        add(lblModelo);
        add(txfModelo);
        add(lblCor);
        add(txfCor);
        add(lblQtdRodas);
        add(txfQtdRodas);
        add(lblVelocMax);
        add(txfVelocMax);
        add(lblQtdPist);
        add(txfQtdPist);
        add(lblPotencia);
        add(txfPotencia);
        add(btnConsultar);
        add(btnExcluir);
        add(btnSair);
    }
    
    protected void inicializaFuncionalidades() {
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnConsultarClique(e);
            }
        });
        
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnExcluirClique(e);
            }
        });
        
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSairClique(e);
            }
        });
    }
    
    protected void preencheCampos(Veiculo veiculo) {
        txfCor     .setText(veiculo.getCor   ());
        txfMarca   .setText(veiculo.getMarca ());
        txfModelo  .setText(veiculo.getModelo());
        txfQtdRodas.setText(Integer.toString(veiculo.getQtdRodas()));
        txfVelocMax.setText(Float  .toString(veiculo.getVelocMax()));
        txfPotencia.setText(Integer.toString(veiculo.getMotor().getPotencia()));
        txfQtdPist .setText(Integer.toString(veiculo.getMotor().getQtdPist ()));   
    }
    
    protected void limpaCampos() {
        txfCor     .setText("");
        txfMarca   .setText(""); 
        txfModelo  .setText(""); 
        txfQtdRodas.setText(""); 
        txfVelocMax.setText(""); 
        txfPotencia.setText(""); 
        txfQtdPist .setText("");
    }
    
    protected void campoPreenchido() throws CampoNaoPreenchidoException{
        if (txfPlaca.getText().isEmpty()|| txfPlaca.getText().isBlank())
            throw new CampoNaoPreenchidoException();
    }
    
    public BDVeiculos getBDVeiculos() {
        return bdVeiculos;
    }
    
    private void btnSairClique(ActionEvent e) {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    abstract void inicializaComponentesFilho();
    
    abstract void btnConsultarClique(ActionEvent e);
    
    abstract void btnExcluirClique(ActionEvent e);
}
