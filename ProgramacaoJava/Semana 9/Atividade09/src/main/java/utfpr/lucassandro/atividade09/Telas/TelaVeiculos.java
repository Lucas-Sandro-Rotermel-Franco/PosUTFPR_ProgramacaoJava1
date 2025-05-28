/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.metal.MetalLookAndFeel;
import utfpr.lucassandro.atividade09.BDVeiculos;

/**
 *
 * @author lucassandro
 */
public class TelaVeiculos extends JFrame {
    private static JButton btnCadastrar        = new JButton();
    private static JButton btnConsultarExcluir = new JButton();
    private static JButton btnImprimirExcluir  = new JButton();
    private static JButton btnSair             = new JButton();
    
    private static JLabel lblCadastrar        = new JLabel("Cadastrar");
    private static JLabel lblConsultarExcluir = new JLabel("ConsultarExcluir");
    private static JLabel lblImprimirExcluir  = new JLabel("ImprimirExcluir");
    private static JLabel lblSair             = new JLabel("Sair");
    
    private String tipoVeiculo;
    
    protected BDVeiculos bdVeiculos;
    
    public TelaVeiculos(String tipoVeiculo, BDVeiculos bdVeiculos) {   
        this.tipoVeiculo = tipoVeiculo;
        this.bdVeiculos = bdVeiculos;
        setTitle("Veículos de " + tipoVeiculo);
        setSize(500, 150);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        inicializaComponentes(tipoVeiculo);
        inicializaFuncionalidades();
    }

    private void inicializaComponentes(String tipoVeiculo) {
        lblCadastrar.setText("Cadastrar");
        lblConsultarExcluir.setText("Consultar / Excluir pela placa");
        lblImprimirExcluir.setText("Imprimir / Excluir todos");
        lblSair.setText("Sair");
        
        btnCadastrar.setPreferredSize(new Dimension(30, 30));
        btnConsultarExcluir.setPreferredSize(new Dimension(30, 30));
        btnImprimirExcluir.setPreferredSize(new Dimension(30, 30));
        btnSair.setPreferredSize(new Dimension(30, 30));
        
        if(tipoVeiculo.equals("Carga")) {
            btnCadastrar.setBackground(Color.green);
            btnConsultarExcluir.setBackground(Color.green);
            btnImprimirExcluir.setBackground(Color.green);
        } else if (tipoVeiculo.equals("Passeio")) {
            btnCadastrar.setBackground(Color.blue);
            btnConsultarExcluir.setBackground(Color.blue);
            btnImprimirExcluir.setBackground(Color.blue);
        }
        
        btnSair.setBackground(Color.red);
        
        for (ActionListener al : btnCadastrar.getActionListeners())
            btnCadastrar.removeActionListener(al);
        
        for (ActionListener al : btnConsultarExcluir.getActionListeners())
            btnConsultarExcluir.removeActionListener(al);
        
        for (ActionListener al : btnImprimirExcluir.getActionListeners())
            btnImprimirExcluir.removeActionListener(al);
        
        for (ActionListener al : btnSair.getActionListeners())
            btnSair.removeActionListener(al);
        
        add(btnCadastrar);
        add(lblCadastrar);
        
        add(btnConsultarExcluir);
        add(lblConsultarExcluir);
        
        add(btnImprimirExcluir);
        add(lblImprimirExcluir);
        
        add(btnSair);
        add(lblSair);
    }
    
    private void inicializaFuncionalidades() {
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCadastrarClique(e);
            }
        });
        
        btnConsultarExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnConsultarExcluir(e);
            }
        });
        
        btnImprimirExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnImprimirExcluir(e);
            }
        });
        
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSairClique(e);
            }
        });
    }
    
    private void btnCadastrarClique(ActionEvent e) {
        if (tipoVeiculo.equals("Passeio")) {
            TelaCadastroPasseio telaCadastroPasseio = new TelaCadastroPasseio(bdVeiculos);
            telaCadastroPasseio.setVisible(true);
            telaCadastroPasseio.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    setBDVeiculos(telaCadastroPasseio.getBDVeiculos());
                    telaCadastroPasseio.dispose();
                }
            });
        } else if (tipoVeiculo.equals("Carga")) {
            TelaCadastroCarga telaCadastroCarga = new TelaCadastroCarga(bdVeiculos);
            telaCadastroCarga.setVisible(true);
            telaCadastroCarga.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    setBDVeiculos(telaCadastroCarga.getBDVeiculos());
                    telaCadastroCarga.dispose();
                }
            });
        }
    }
    
    private void btnConsultarExcluir(ActionEvent e) {
        if (tipoVeiculo.equals("Passeio")) {
            TelaConsultaExcluiPasseio telaConsultaExcluiPasseio = new TelaConsultaExcluiPasseio(bdVeiculos);
            telaConsultaExcluiPasseio.setVisible(true);
            telaConsultaExcluiPasseio.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    setBDVeiculos(telaConsultaExcluiPasseio.getBDVeiculos());
                    telaConsultaExcluiPasseio.dispose();
                }
            });
        } else if (tipoVeiculo.equals("Carga")) {
            TelaConsultaExcluiCarga telaConsultaExcluiCarga = new TelaConsultaExcluiCarga(bdVeiculos);
            telaConsultaExcluiCarga.setVisible(true);
            telaConsultaExcluiCarga.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    setBDVeiculos(telaConsultaExcluiCarga.getBDVeiculos());
                    telaConsultaExcluiCarga.dispose();
                }
            });
        }
    }
    
    private void btnImprimirExcluir(ActionEvent e) {
        if (tipoVeiculo.equals("Passeio")) {
            TelaImprimirExcluirPasseio telaImprimirExcluirPasseio = new TelaImprimirExcluirPasseio(bdVeiculos);
            telaImprimirExcluirPasseio.setVisible(true);
            telaImprimirExcluirPasseio.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    setBDVeiculos(telaImprimirExcluirPasseio.getBDVeiculos());
                    telaImprimirExcluirPasseio.dispose();
                }
            });
        } else if (tipoVeiculo.equals("Carga")) {
            TelaImprimirExcluirCarga telaImprimirExcluirCarga = new TelaImprimirExcluirCarga(bdVeiculos);
            telaImprimirExcluirCarga.setVisible(true);
            telaImprimirExcluirCarga.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    setBDVeiculos(telaImprimirExcluirCarga.getBDVeiculos());
                    telaImprimirExcluirCarga.dispose();
                }
            });
        }
    }
    
    private void btnSairClique(ActionEvent e) {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        dispose();
    }
    
    private void setBDVeiculos(BDVeiculos bdVeiculos) {
        this.bdVeiculos = bdVeiculos;
    }
    
    public BDVeiculos getBDVeiculos() {
        return bdVeiculos;
    }
}
