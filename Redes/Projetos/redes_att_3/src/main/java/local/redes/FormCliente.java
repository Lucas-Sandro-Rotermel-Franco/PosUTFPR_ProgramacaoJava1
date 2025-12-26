package local.redes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// @author Lucas Sandro Rotermel Franco
public class FormCliente extends JFrame {
    private JLabel lblNome = new JLabel("Nome");
    private JLabel lblIdade = new JLabel("Idade");
    private JLabel lblRetorno = new JLabel("Retorno do Servidor");

    private JTextField txfNome = new JTextField(30);
    private JTextField txfIdade = new JTextField(30);
    
    private JTextArea txaRetorno = new JTextArea(5, 30);
    
    private JButton btnEnviar = new JButton("Enviar");

    private static Socket socket;
    private static ObjectOutputStream saida;
    private static DataInputStream entrada;

    public FormCliente() {
        setTitle("");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        inicializaComponentes();
        inicializaFuncionalidades();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializaFuncionalidades() {
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEnviarClique(e);
            }
        });
    }

    private void btnEnviarClique(ActionEvent e) {
        if (camposVazios()) {
            JOptionPane.showMessageDialog(null, "Existem campos não preenchidos", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nome = txfNome.getText().trim();
        int idade = 0;

        try {
            idade = Integer.parseInt(txfIdade.getText().trim());

            if (idade < 0)
                throw new NumberFormatException("Idade negativa");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, insira uma idade válida (número inteiro positivo).",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setIdade(idade);
        pessoa.setNome(nome);

        enviaPessoaParaServidor(pessoa);
    }

    private void enviaPessoaParaServidor(Pessoa pessoa) {
        try {
            socket = new Socket("127.0.0.1", 50000);
            saida = new ObjectOutputStream(socket.getOutputStream());

            saida.writeObject(pessoa);

            entrada = new DataInputStream(socket.getInputStream());
            String resposta = entrada.readUTF();

            txaRetorno.setText("Recebeu do servidor:\n" + resposta);

            saida.close();
            socket.close();
            entrada.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean camposVazios() {
        if (txfIdade.getText().isEmpty() || txfIdade.getText().isBlank())
            return true;

        if (txfNome.getText().isEmpty() || txfNome.getText().isBlank())
            return true;

        return false;
    }

    private void inicializaComponentes() {
        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel pnlNome = new JPanel(new BorderLayout(5, 5));
        pnlNome.add(lblNome, BorderLayout.NORTH);
        pnlNome.add(txfNome, BorderLayout.CENTER);
        
        JPanel pnlIdade = new JPanel(new BorderLayout(5, 5));
        pnlIdade.add(lblIdade, BorderLayout.NORTH);
        pnlIdade.add(txfIdade, BorderLayout.CENTER);

        JPanel pnlRetorno = new JPanel(new BorderLayout(5, 5));
        pnlRetorno.add(lblRetorno, BorderLayout.NORTH);
        txaRetorno.setEditable(false);
        txaRetorno.setLineWrap(true);
        txaRetorno.setWrapStyleWord(true);
        txaRetorno.setMargin(new Insets(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(txaRetorno);
        pnlRetorno.add(scrollPane, BorderLayout.CENTER);
        
        for (ActionListener al : btnEnviar.getActionListeners())
            btnEnviar.removeActionListener(al);

        JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlButton.add(btnEnviar);
        
        pnlMain.add(pnlNome);
        pnlMain.add(Box.createVerticalStrut(10));
        pnlMain.add(pnlIdade);
        pnlMain.add(Box.createVerticalStrut(10));
        pnlMain.add(pnlRetorno);
        pnlMain.add(Box.createVerticalStrut(10));
        pnlMain.add(pnlButton);
        
        this.setContentPane(pnlMain);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormCliente::new);
    }
}
