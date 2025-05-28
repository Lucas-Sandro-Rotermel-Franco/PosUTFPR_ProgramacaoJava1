/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import utfpr.lucassandro.atividade09.BDVeiculos;

/**
 *
 * @author lucassandro
 */
public abstract class TelaImprimirExcluirVeiculo extends JFrame {
    protected String[] colunas = { "Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc Máx", "Qtd. Pist", "Potência" };
    protected DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
    
    protected JTable tabelaVeiculos = new JTable(modeloTabela);
    
    protected JScrollPane containerTabela = new JScrollPane(tabelaVeiculos);
    
    private JButton btnImprimirTodos = new JButton();
    private JButton btnExcluirTodos  = new JButton();
    private JButton btnSair          = new JButton();
    
    protected BDVeiculos bdVeiculos;
    
    public TelaImprimirExcluirVeiculo(BDVeiculos bdVeiculos) {
        this.bdVeiculos = bdVeiculos;
        setTitle("Imprimir/Excluir todos");
        setSize(700, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        inicializaComponentes();
        inicializaFuncionalidades();
    }

    private void inicializaComponentes() {
        btnImprimirTodos.setText("Imprimir Todos");
        btnImprimirTodos.setBackground(Color.yellow);
        btnImprimirTodos.setForeground(Color.red);
        
        btnExcluirTodos.setText("Excluir Todos");
        btnExcluirTodos.setBackground(Color.yellow);
        btnExcluirTodos.setForeground(Color.red);
        
        btnSair.setText("Sair");
        
        inicializaComponentesFilho();
        
        containerTabela.setPreferredSize(new Dimension(500, 500));
        
        for (ActionListener al : btnSair.getActionListeners())
            btnSair.removeActionListener(al);
        
        for (ActionListener al : btnImprimirTodos.getActionListeners())
            btnImprimirTodos.removeActionListener(al);
        
        for (ActionListener al : btnExcluirTodos.getActionListeners())
            btnExcluirTodos.removeActionListener(al);
        
        add(containerTabela);
        add(btnImprimirTodos);
        add(btnExcluirTodos);
        add(btnSair);
    }
    
    private void inicializaFuncionalidades() {
        btnExcluirTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnExcluirClique(e);
            }
        });
        
        btnImprimirTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnImprimirClique(e);
            }
        });
        
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSairClique(e);
            }
        });
        
    }
    
    private void btnSairClique(ActionEvent e) {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    public BDVeiculos getBDVeiculos() {
        return bdVeiculos;
    }
    
    protected void limpaTabela() {
        modeloTabela.setRowCount(0);
    }

    abstract void inicializaComponentesFilho();
    
    abstract void btnExcluirClique(ActionEvent e);
    
    abstract void btnImprimirClique(ActionEvent e);    
}
