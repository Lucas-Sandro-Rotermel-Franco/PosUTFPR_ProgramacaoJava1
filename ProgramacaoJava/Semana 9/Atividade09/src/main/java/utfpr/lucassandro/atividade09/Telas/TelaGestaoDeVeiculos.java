/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.atividade09.Telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utfpr.lucassandro.atividade09.BDVeiculos;
import utfpr.lucassandro.atividade09.Telas.TelaVeiculos;

/**
 *
 * @author lucassandro
 */
public class TelaGestaoDeVeiculos extends JFrame{
    
    private static JLabel lblPasseio = new JLabel("Passeio");
    private static JLabel lblCarga   = new JLabel("Carga");
    
    private static JButton btnPasseio = new JButton();
    private static JButton btnCarga   = new JButton();
    
    private BDVeiculos bdVeiculos;
    
    public TelaGestaoDeVeiculos(BDVeiculos bdVeiculos) {
        this.bdVeiculos = bdVeiculos;
        setTitle("Gestão de Veículos");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        inicializaComponentes();
        inicializaFuncionalidades();
    }
    
    private void inicializaComponentes() {
        lblPasseio.setText("Passeio");
        lblCarga.setText("Carga");
        
        btnPasseio.setBackground(Color.blue);
        btnPasseio.setPreferredSize(new Dimension(30, 30));
        
        btnCarga.setBackground(Color.green);
        btnCarga.setPreferredSize(new Dimension(30, 30));
        
        for (ActionListener al : btnPasseio.getActionListeners())
            btnPasseio.removeActionListener(al);
        
        for (ActionListener al : btnCarga.getActionListeners())
            btnCarga.removeActionListener(al);
        
        add(btnPasseio);
        add(lblPasseio);
        
        add(btnCarga);
        add(lblCarga);        
    }

    private void inicializaFuncionalidades() {
        btnPasseio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnPasseioClique(e);
            }
        });
        
        btnCarga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCargaClique(e);
            }
        });
    }
    
    
    private void btnPasseioClique(ActionEvent e) {
        TelaVeiculos telaVeiculos = new TelaVeiculos("Passeio", bdVeiculos);
        telaVeiculos.setVisible(true);
        telaVeiculos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                setBDVeiculos(telaVeiculos.getBDVeiculos());
                Component[] componentes = telaVeiculos.getContentPane().getComponents();
                    for (int idx = 0; idx < componentes.length; ++idx) {
                        if (componentes[idx] instanceof JButton) {
                            ActionListener[] actListener = (ActionListener[])componentes[idx].getListeners(ActionListener.class);
                            for (int idx2 = 0; idx < actListener.length; ++idx2) {
                                ((JButton)componentes[idx]).removeActionListener(actListener[idx2]);
                            }
                        }
                    }
            }
        });
    }
    
    private void setBDVeiculos(BDVeiculos bdVeiculos) {
        this.bdVeiculos = bdVeiculos;
    }
    
    private void btnCargaClique(ActionEvent e) {
        TelaVeiculos telaVeiculos = new TelaVeiculos("Carga", bdVeiculos);
        telaVeiculos.setVisible(true);
    }
}
